package com.example.travelapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PredictedWeatherFragment extends Fragment {
    private RecyclerView recyclerView;
    private WeatherAdapter adapter;
    private double latitude;
    private double longitude;

    private Context mContext;

    public PredictedWeatherFragment(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predicted_weather, container, false);

        recyclerView = view.findViewById(R.id.recycler_weather_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchWeatherData();

        return view;
    }

    private void fetchWeatherData() {
        String apiKey = "e08a1024a7ec6fd9070b21cf9e10269c";
        String weatherUrl = "https://api.openweathermap.org/data/3.0/onecall?lat=" + latitude + "&lon=" + longitude + "&exclude=alerts&appid=" + apiKey;
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest weatherRequest = new StringRequest(Request.Method.GET, weatherUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray hourlyArray = jsonObject.getJSONArray("hourly");

                    ArrayList<WeatherItem> weatherItems = new ArrayList<>();
                    for (int i = 0; i < hourlyArray.length(); i++) {
                        JSONObject hourlyObject = hourlyArray.getJSONObject(i);
                        long unixTimestamp = hourlyObject.getLong("dt");
                        double temperature = hourlyObject.getDouble("temp");
                        String weatherDescription = hourlyObject.getJSONArray("weather").getJSONObject(0).getString("description");

                        // Convert Unix timestamp to formatted date and time with AM/PM
                        String formattedDateTime = convertUnixTimestamp(unixTimestamp);
                        String formattedTemperature = String.format("%.2f °C", ((temperature - 32) * 5 / 9));

                        // Combine these values as needed and add to the weatherItems list
                        String formattedWeather = formattedDateTime + "\nTemperature: " + formattedTemperature + "\nDescription: " + weatherDescription;
                        weatherItems.add(new WeatherItem(formattedDateTime, formattedWeather));
                    }

                    // Create and set the adapter for the RecyclerView
                    WeatherAdapter adapter = new WeatherAdapter(weatherItems);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error responses here
                System.out.println("Something went wrong");
            }
        });

        queue.add(weatherRequest);
    }

    private String convertUnixTimestamp(long unixTimestamp) {
        Date date = new Date(unixTimestamp * 1000L); // Convert to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault());
        return sdf.format(date);
    }

}