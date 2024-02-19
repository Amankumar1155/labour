package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

public class Registrationform extends AppCompatActivity {
    ImageView img;
    EditText dob,name,email,address,pass,repassword;
    TextView taplocation;
    int date,month,year;
    Button  btn;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Select_service.class));
        finish();
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        btn = findViewById(R.id.submitt);


        dob = findViewById(R.id.dateOfBirth);

        name=findViewById(R.id.nameenter);
        email=findViewById(R.id.enteremail);
        address=findViewById(R.id.enteradd);
        pass=findViewById(R.id.newpassword);
        repassword=findViewById(R.id.reEnterPassword);
        taplocation=findViewById(R.id.mapclick);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Registrationform.this, listener, date, month, year).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String address1 = address.getText().toString();
                String dob1 = dob.getText().toString();
                String passwrd = pass.getText().toString();
                String reEnterPass = repassword.getText().toString();

               Toast.makeText(Registrationform.this, "Name:- " + name1, Toast.LENGTH_SHORT).show();
                Toast.makeText(Registrationform.this, "Email: " + email1, Toast.LENGTH_SHORT).show();
                Toast.makeText(Registrationform.this, "Address: " + address1, Toast.LENGTH_SHORT).show();
                Toast.makeText(Registrationform.this, "Date of Birth: " + dob1, Toast.LENGTH_SHORT).show();
                Toast.makeText(Registrationform.this, "Password: " + passwrd + "Re-enter Password: " + reEnterPass, Toast.LENGTH_SHORT).show();

                Log.d("sdfghjklkjhgfdasdfgh","Re"+reEnterPass);

                Intent intent = new Intent(Registrationform.this, Kycprocess.class);
                startActivity(intent);
                finish();
            }
        });
    }
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dob.setText(i2 + "/" + (i1 + 1) + "/" + i);
        }
    };

}