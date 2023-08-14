package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeFrance extends AppCompatActivity {
    private static final int MAP_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_france);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MapsFragment(48.8566, 2.3522, "France"))
                    .commit();
        }
    }

    public void openFranceAccomodations(View view) {
        Intent intent = new Intent(HomeFrance.this, FranceAccomodations.class);
        startActivity(intent);
    }

    public void openFranceCuisines(View view) {
        Intent intent = new Intent(HomeFrance.this, FrancceCuisines.class);
        startActivity(intent);
    }

    public void openFranceGallery(View view) {
        Intent intent = new Intent(HomeFrance.this, FranceGallary.class);
        startActivity(intent);
    }

    public void openFranceGettingAround(View view) {
        Intent intent = new Intent(HomeFrance.this, FranceGettingAround.class);
        startActivity(intent);
    }

}