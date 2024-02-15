package com.aman.labour;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    CardView card1;
    Button btn1,btn2;

    ImageView imageView ;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView, wallet;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Kycprocess.class));
        finish();
    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




        card1=findViewById(R.id.workorder);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationViews = findViewById(R.id.nav_view);
        View headerView = navigationViews.getHeaderView(0);



        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        wallet=findViewById(R.id.bank);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home)
            {
                Toast.makeText(this, "This is home", Toast.LENGTH_SHORT).show();
            } else if (itemId==R.id.nav_profile)
            {
                Toast.makeText(this, "This is profile", Toast.LENGTH_SHORT).show();
            }

            drawerLayout.closeDrawer(navigationView);

            return true;
        });


            imageView=findViewById(R.id.tv_drawer_nav);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Workordercard.class));
                finish();

            }
        });


    }
}
