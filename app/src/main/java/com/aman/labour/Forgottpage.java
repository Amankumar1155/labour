package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Forgottpage extends AppCompatActivity {








    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Loginpage.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgottpage);
    }
}