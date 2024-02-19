package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

public class Loginpage extends AppCompatActivity {
    Button log;
    ImageView call, whatsapp;
    TextView btn;

    EditText e1,e2;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        log=findViewById(R.id.Login_btn);
        call = findViewById(R.id.callbtn);
        whatsapp = findViewById(R.id.whatsappbtn);
        btn = findViewById(R.id.passreset);
        e1=findViewById(R.id.loginid);
        e2=findViewById(R.id.password);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = e1.getText().toString();
                String pass = e2.getText().toString();
                Toast.makeText(Loginpage.this, "Number is:- "+id, Toast.LENGTH_SHORT).show();
                Toast.makeText(Loginpage.this, "Password is:- "+pass, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Loginpage.this, Dashboard.class);
                startActivity(intent);
                finish();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginpage.this, Forgottpage.class));
                finish();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCallConfirmationDialog();
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWhatsAppConfirmationDialog();
            }
        });
    }

    private void showCallConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Loginpage.this);
        builder.setTitle("Confirm Call");
        builder.setMessage("Are you sure you want to call 7398869340");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                makePhoneCall();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Loginpage.this, "Call Permisson Denied", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void makePhoneCall() {
        if (ContextCompat.checkSelfPermission(Loginpage.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            String phoneNumber = "tel:" + "7398869340";
            Intent dial = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
            startActivity(dial);
        } else {

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }

    private void showWhatsAppConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Loginpage.this);
        builder.setTitle("Confirm WhatsApp Message");
        builder.setMessage("Do you want to send a WhatsApp message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendWhatsAppMessage();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Loginpage.this, "WhatsApp Permisson Denied", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void sendWhatsAppMessage() {
        String phoneNumber = "7398869340";
        String message = "Hi!";

        Uri uri = Uri.parse("https://wa.me/" + phoneNumber + "?text=" + Uri.encode(message));
        Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(sendIntent);
    }
}
