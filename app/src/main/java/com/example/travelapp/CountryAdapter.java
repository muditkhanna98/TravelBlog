package com.example.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countries;
    private Context context;

    public CountryAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    public void updateData(List<Country> newData) {
        countries.clear();
        countries.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        private ImageView countryImage;
        private Button countryButton;
        private TextView countryDescription;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryImage = itemView.findViewById(R.id.countryImage);
            countryButton = itemView.findViewById(R.id.countryButton);
            countryDescription = itemView.findViewById(R.id.countryDescription);

            countryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Country clickedCountry = countries.get(position);
                        openCountryActivity(clickedCountry.getName());
                    }
                }
            });
        }

        private void openCountryActivity(String countryName) {
            if (countryName.equals("China")) {
                Intent intent = new Intent(context, HomeChina.class);
                context.startActivity(intent);
            } else if (countryName.equals("France")) {
                Intent intent = new Intent(context, HomeFrance.class);
                context.startActivity(intent);
            } else if (countryName.equals("Spain")) {
                Intent intent = new Intent(context, HomeSpain.class);
                context.startActivity(intent);
            } else if (countryName.equals("Japan")) {
                Intent intent = new Intent(context, HomeJapan.class);
                context.startActivity(intent);
            }
        }

        public void bind(Country country) {
            countryImage.setImageResource(country.getImageResId());
            countryButton.setText(country.getName());
            countryDescription.setText(country.getDescription());
        }
    }
}
