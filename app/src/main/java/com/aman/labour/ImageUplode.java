package com.aman.labour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageUplode extends AppCompatActivity {

    Button uplodedbtn;
    ImageButton camerabtn;
    RecyclerView recyclerView;
    ImageButton pick;
    Button deleteBtn; // Added delete button
    ArrayList<Uri> uri = new ArrayList<>();
    RecyclerAdapter adapter;
    private static final int Read_Permission = 101;
    private static final int CAMERA_REQUEST_CODE = 102;
    private static final int MAX_PHOTOS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_uplode);

        uplodedbtn = findViewById(R.id.uplodeitbtn);
        recyclerView = findViewById(R.id.recycleView_Gallery_Images);
        pick = findViewById(R.id.pick);
        camerabtn = findViewById(R.id.camerauplode);
        deleteBtn = findViewById(R.id.deleteBtn); // Initialize delete button

        adapter = new RecyclerAdapter(uri);

        uplodedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageUplode.this, "Photos uploaded", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ImageUplode.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(ImageUplode.this, 4));
        recyclerView.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(ImageUplode.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ImageUplode.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Read_Permission);
        }

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });

        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        // Delete button click listener
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete all selected images
                uri.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.getClipData() != null) {
                    int x = data.getClipData().getItemCount();
                    for (int i = 0; i < x && uri.size() < MAX_PHOTOS; i++) {
                        uri.add(data.getClipData().getItemAt(i).getUri());
                    }
                    adapter.notifyDataSetChanged();
                } else if (data.getData() != null && uri.size() < MAX_PHOTOS) {
                    String imageURL = data.getData().getPath();
                    uri.add(Uri.parse(imageURL));
                    adapter.notifyDataSetChanged();
                }
            }
        } else if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK && uri.size() < MAX_PHOTOS) {
            if (data != null && data.getExtras() != null) {
                Uri imageUri = data.getData();
                uri.add(imageUri);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
