package com.example.travelapp;

public class WeatherItem {
    private String time;
    private String weather;

    public WeatherItem(String time, String weather) {
        this.time = time;
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public String getWeather() {
        return weather;
    }
}
