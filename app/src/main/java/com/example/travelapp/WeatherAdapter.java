package com.example.travelapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private ArrayList<WeatherItem> weatherItems;

    public WeatherAdapter(ArrayList<WeatherItem> weatherItems) {
        this.weatherItems = weatherItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherItem weatherItem = weatherItems.get(position);
        holder.timeTextView.setText(weatherItem.getTime());
        holder.weatherTextView.setText(weatherItem.getWeather());
    }

    @Override
    public int getItemCount() {
        return weatherItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView;
        TextView weatherTextView;

        ViewHolder(View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            weatherTextView = itemView.findViewById(R.id.weatherTextView);
        }
    }
}
