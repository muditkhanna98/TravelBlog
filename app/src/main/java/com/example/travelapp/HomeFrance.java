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

    public void openFranceMap(View view) {
        String parameter = "+46.2276,2.2137?z=7";
        Uri mapURI = Uri.parse("geo:" + parameter);
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapURI); //mapsIntent.setData(mapURI);
        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }
        Toast.makeText(this, "Routing to France", Toast.LENGTH_SHORT).show();
        startActivityForResult(mapsIntent, MAP_REQUEST);
    }
}