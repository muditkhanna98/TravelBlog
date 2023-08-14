package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PredictedWeather extends AppCompatActivity {

    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predicted_weather);

        Intent intent = getIntent();
        if (intent != null) {
            latitude = intent.getDoubleExtra("lat", 0.0);
            longitude = intent.getDoubleExtra("lon", 0.0);
        }

        PredictedWeatherFragment fragment = new PredictedWeatherFragment(latitude, longitude);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}