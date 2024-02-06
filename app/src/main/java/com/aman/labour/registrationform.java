package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class registrationform extends AppCompatActivity {
    Button btn;
    Spinner sp1,sp2;
    EditText dob;
    int date,month,year;

    String category[],service[],service2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        btn=findViewById(R.id.submit);

        sp1=findViewById(R.id.category);
        sp2=findViewById(R.id.services);

        category=getResources().getStringArray(R.array.service_category);
        service=getResources().getStringArray(R.array.daily_worker_services);
        service2=getResources().getStringArray(R.array.permanant_worker_services);


        ArrayAdapter<String> categoryAdapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, category);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,service);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, service2);

        sp1.setAdapter(categoryAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (position==0)
                {
                    sp2.setAdapter(adapter);
                }
                else
                {
                    sp2.setAdapter(adapter2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dob=findViewById(R.id.dateOfBirth);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(registrationform.this,listener,date,month,year).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registrationform.this,Dashboard.class));
                finish();
            }
        });

    }

    DatePickerDialog.OnDateSetListener listener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
        {
            dob.setText(i2+"/"+(i1+1)+"/"+i);
        }
    };

}