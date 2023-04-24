package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openChinaHome(View view) {
        Intent intent = new Intent(MainActivity.this, HomeChina.class);
        startActivity(intent);
    }

    public void openFranceHome(View view) {
        Intent intent = new Intent(MainActivity.this, HomeFrance.class);
        startActivity(intent);
    }

    public void openJapanHome(View view) {
        Intent intent = new Intent(MainActivity.this, HomeJapan.class);
        startActivity(intent);
    }

    public void openSpainHome(View view) {
        Intent intent = new Intent(MainActivity.this, HomeSpain.class);
        startActivity(intent);
    }

    public void openContactUs(View view){
        Intent intent = new Intent(MainActivity.this, ContactUs.class);
        startActivity(intent);
    }
}