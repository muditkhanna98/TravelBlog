package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpainGallary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spain_gallary);
    }

    public void openZoomedImage(View view) {
        String resourceName = getResources().getResourceEntryName(view.getId());
        Intent intent = new Intent(SpainGallary.this, ZoomImageView.class);
        intent.putExtra("image_resource", resourceName);
        startActivity(intent);
    }
}