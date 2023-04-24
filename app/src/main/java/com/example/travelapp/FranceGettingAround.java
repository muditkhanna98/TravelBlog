package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FranceGettingAround extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_france_getting_around);

        ImageView myImage = findViewById(R.id.my_image);
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        myImage.startAnimation(blinkAnimation);
    }
}