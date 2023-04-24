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

    public void openSpainMap(View view) {
        String parameter = "+40.4168,3.7038?z=7";
        Uri mapURI = Uri.parse("geo:" + parameter);
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapURI); //mapsIntent.setData(mapURI);
        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }
        Toast.makeText(this, "Routing to Spain", Toast.LENGTH_SHORT).show();
        startActivityForResult(mapsIntent, MAP_REQUEST);
    }
}