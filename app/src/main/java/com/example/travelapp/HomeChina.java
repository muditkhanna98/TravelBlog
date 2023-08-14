package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;

public class HomeChina extends AppCompatActivity {
    private static final int MAP_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_china);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MapsFragment(35.8617, 104.1954,"China"))
                    .commit();
        }
    }

    public void openChinaAccomodations(View view) {
        Intent intent = new Intent(HomeChina.this, ChinaAccomodations.class);
        startActivity(intent);
    }

    public void openChinaCuisines(View view) {
        Intent intent = new Intent(HomeChina.this, ChinaCuisines.class);
        startActivity(intent);
    }

    public void openChinaGallery(View view) {
        Intent intent = new Intent(HomeChina.this, ChinaGallary.class);
        startActivity(intent);
    }

    public void openChinaGettingAround(View view) {
        Intent intent = new Intent(HomeChina.this, ChinaGettingAround.class);
        startActivity(intent);
    }
}