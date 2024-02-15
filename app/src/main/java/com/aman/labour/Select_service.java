package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aman.labour.Adapter.ServiceAdapter;

public class Select_service extends AppCompatActivity {

    RecyclerView recyclerView;

    String names[]={"Ram","Shyam"};

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, OtpVerification.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);

        recyclerView=findViewById(R.id.gridRecyclerView);

        ServiceAdapter adapter =new ServiceAdapter(names,this);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);


    }
}