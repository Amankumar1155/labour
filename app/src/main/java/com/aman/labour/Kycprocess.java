package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Kycprocess extends AppCompatActivity {

    CardView btn1;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, registrationform.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kycprocess);

        btn1=findViewById(R.id.docsubmit);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Kycprocess.this, Dashboard.class));
                finish();
            }
        });
    }
}