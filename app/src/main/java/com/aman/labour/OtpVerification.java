package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpVerification extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        submit = findViewById(R.id.otp_submit);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move these lines inside the onClick method
                String e11 = e1.getText().toString();
                String e12 = e2.getText().toString();
                String e13 = e3.getText().toString();
                String e14 = e4.getText().toString();

                Toast.makeText(OtpVerification.this, " " + e11 + " " + e12 + " " + e13 + " " + e14, Toast.LENGTH_SHORT).show();
            }
        });
        submit=findViewById(R.id.otp_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpVerification.this, customerPartner.class));
                finish();
            }
        });
    }
}
