package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeJapan extends AppCompatActivity {
    private static final int MAP_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_japan);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MapsFragment(35.6895, 139.6917, "Japan"))
                    .commit();
        }
    }

    public void openJapanAccomodations(View view) {
        Intent intent = new Intent(HomeJapan.this, JapanAccomodations.class);
        startActivity(intent);
    }

    public void openJapanCuisines(View view) {
        Intent intent = new Intent(HomeJapan.this, JapanCuisines.class);
        startActivity(intent);
    }

    public void openJapanGallery(View view) {
        Intent intent = new Intent(HomeJapan.this, JapanGallary.class);
        startActivity(intent);
    }

    public void openJapanGettingAround(View view) {
        Intent intent = new Intent(HomeJapan.this, JapanGettingAround.class);
        startActivity(intent);
    }

}