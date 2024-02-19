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

    EditText e1;
    Button submit;



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        submit=findViewById(R.id.otp_submit);


        e1 = findViewById(R.id.otpEnter);


        submit = findViewById(R.id.otp_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String otpNumber=e1.getText().toString();
                Toast.makeText(OtpVerification.this, "Your OTP :- "+otpNumber, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(OtpVerification.this, Select_service.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
