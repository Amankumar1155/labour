package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerPartner extends AppCompatActivity {
    Button btn1;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_partner);
        btn1 = findViewById(R.id.part12);
        btn2=findViewById(R.id.customerregister);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customerPartner.this, partnerregistration.class));
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customerPartner.this, customerregisation.class));
                finish();

            }
        });
    }
}
