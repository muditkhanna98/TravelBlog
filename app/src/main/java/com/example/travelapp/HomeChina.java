package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeChina extends AppCompatActivity {
    private static final int MAP_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_china);
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

    public void openChinaMap(View view) {
        String parameter = "+39.9042,116.4074?z=10";
        Uri mapURI = Uri.parse("geo:" + parameter);
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapURI); //mapsIntent.setData(mapURI);
        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        }
        Toast.makeText(this, "Routing to china", Toast.LENGTH_SHORT).show();
        startActivityForResult(mapsIntent, MAP_REQUEST);
    }

}