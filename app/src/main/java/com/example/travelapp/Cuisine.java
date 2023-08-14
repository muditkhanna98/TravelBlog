package com.example.travelapp;

public class Cuisine {
    private int imageResId;
    private String name;
    private String description;

    public Cuisine(int imageResId, String name, String description) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

