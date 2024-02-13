package com.aman.labour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aman.labour.Adapter.ServiceAdapter;

public class Select_service extends AppCompatActivity {

    RecyclerView recyclerView;

    String names[]={"Ram","Shyam"};


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