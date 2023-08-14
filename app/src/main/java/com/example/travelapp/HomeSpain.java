package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeSpain extends AppCompatActivity {
    private static final int MAP_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_spain);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MapsFragment(40.4168, -3.7038, "Spain"))
                    .commit();
        }
    }

    public void openSpainAccomodations(View view) {
        Intent intent = new Intent(HomeSpain.this, SpainAccomodations.class);
        startActivity(intent);
    }

    public void openSpainCuisines(View view) {
        Intent intent = new Intent(HomeSpain.this, SpainCuisines.class);
        startActivity(intent);
    }

    public void openSpainGallery(View view) {
        Intent intent = new Intent(HomeSpain.this, SpainGallary.class);
        startActivity(intent);
    }

    public void openSpainGettingAround(View view) {
        Intent intent = new Intent(HomeSpain.this, SpainGettingAround.class);
        startActivity(intent);
    }
}