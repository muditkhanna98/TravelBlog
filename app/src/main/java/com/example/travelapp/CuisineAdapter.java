package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private List<Cuisine> cuisines;
    private Context context;

    public CuisineAdapter(List<Cuisine> cuisines, Context context) {
        this.cuisines = cuisines;
        this.context = context;
    }

    @NonNull
    @Override
    public CuisineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cuisine, parent, false);
        return new CuisineViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CuisineViewHolder holder, int position) {
        Cuisine cuisine = cuisines.get(position);
        holder.bind(cuisine);
    }

    @Override
    public int getItemCount() {
        return cuisines.size();
    }

    class CuisineViewHolder extends RecyclerView.ViewHolder {
        private ImageView cuisineImage;
        private TextView cuisineName;
        private TextView cuisineDescription;

        public CuisineViewHolder(@NonNull View itemView) {
            super(itemView);
            cuisineImage = itemView.findViewById(R.id.cuisineImage);
            cuisineName = itemView.findViewById(R.id.cuisineName);
            cuisineDescription = itemView.findViewById(R.id.cuisineDescription);
        }

        public void bind(Cuisine cuisine) {
            cuisineImage.setImageResource(cuisine.getImageResId());
            cuisineName.setText(cuisine.getName());
            cuisineDescription.setText(cuisine.getDescription());
        }
    }
}