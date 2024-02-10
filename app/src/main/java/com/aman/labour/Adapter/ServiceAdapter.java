package com.aman.labour.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aman.labour.R;
import com.aman.labour.registrationform;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder>
{

    String cardName[];
    Context context;

    public ServiceAdapter(String[] cardName, Context context) {

        this.cardName = cardName;
        this.context = context;
    }


    @NonNull
    @Override
    public ServiceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myLayout= LayoutInflater.from(context).inflate(R.layout.service_custom_layout,parent,false);

        ServiceAdapter.MyViewHolder holder=new ServiceAdapter.MyViewHolder(myLayout);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.textView.setText(cardName[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardName[position]=="Ram")
                {
                    Intent intent=new Intent(context, registrationform.class);
                    context.startActivity(intent);
                }
                
                else
                {
                    Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.card_second);

        }
    }
}
