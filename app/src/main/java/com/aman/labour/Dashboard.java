package com.aman.labour;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    Button refer, urllink, rate, kyc;
    Button btn;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private static final int REQUEST_CODE_PICK_IMAGES = 100;
    private boolean isKYCCompleted = false; // Flag to track KYC completion

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        kyc = findViewById(R.id.ekycc);
        refer = findViewById(R.id.reffer);
        urllink = findViewById(R.id.rateplay);
        rate = findViewById(R.id.customerrate);

        btn = findViewById(R.id.uplodebtn1);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(Dashboard.this, ImageUplode.class));
            finish();
        });

        refer.setOnClickListener(v -> refer());
        urllink.setOnClickListener(v -> openWebPage("https://alltradsolutions.com/"));
        rate.setOnClickListener(v -> showRatingDialog());

        kyc.setOnClickListener(v -> {
            if (!isKYCCompleted) {
                openGalleryForKYC();
            } else {
                Toast.makeText(this, "KYC already done! 😊", Toast.LENGTH_SHORT).show();
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks here
            drawerLayout.closeDrawers(); // Close the drawer after item click
            return true;
        });
    }

    private void openGalleryForKYC() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGES && resultCode == RESULT_OK) {
            // Handle selected images for KYC
            // Add your logic here
            isKYCCompleted = true; // Set KYC completion flag
            Toast.makeText(this, "KYC done successfully! 😊", Toast.LENGTH_SHORT).show();
        }
    }

    private void showRatingDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_rate_customer, null);
        RatingBar ratingBar = view.findViewById(R.id.ratingBars);

        new AlertDialog.Builder(this)
                .setView(view)
                .setTitle("Rate the Customer")
                .setPositiveButton("Submit", (dialog, which) -> {
                    float rating = ratingBar.getRating();
                    Toast.makeText(this, "Rating successful: 😊😊", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void refer() {
        final String appPackageName = getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download Now: https://alltradsolutions.com/" + appPackageName);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
