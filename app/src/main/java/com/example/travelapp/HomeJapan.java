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

    public void openJapanMap(View view) {
        String parameter = "+35.6762,139.6503?z=7";
        Uri mapURI = Uri.parse("geo:" + parameter);
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapURI); //mapsIntent.setData(mapURI);
        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }
        Toast.makeText(this, "Routing to Japan", Toast.LENGTH_SHORT).show();
        startActivityForResult(mapsIntent, MAP_REQUEST);
    }
}