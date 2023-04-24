package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JapanGallary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_gallary);
    }

    public void openZoomedImage(View view) {
        String resourceName = getResources().getResourceEntryName(view.getId());
        Intent intent = new Intent(JapanGallary.this, ZoomImageView.class);
        intent.putExtra("image_resource", resourceName);
        startActivity(intent);
    }
}