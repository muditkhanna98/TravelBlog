package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button contactBtn;
    private AutoCompleteTextView countriesAutoComplete;
    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countries = new ArrayList<>();
    private List<Country> original = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        contactBtn = findViewById(R.id.contactButton);
        countriesAutoComplete = findViewById(R.id.autoCom);

        initializeRecyclerView();

        countries.add(new Country(R.drawable.china, "China", "It is the world’s most populous country, the Han (ethnic Chinese) forming more than nine-tenths of the population."));
        countries.add(new Country(R.drawable.france, "France", "France, officially French Republic, Country, northwestern Europe. It includes the island of Corsica. Area: 210,017 sq mi (543,941 sq km). Population: (2021 est.) 65,404,000.Capital: Paris."));
        countries.add(new Country(R.drawable.spain, "Spain", "Spain, country located in extreme southwestern Europe. It occupies about 85 percent of the Iberian Peninsula, which it shares with its smaller neighbour Portugal."));
        countries.add(new Country(R.drawable.japan, "Japan", "Japan, Island country, East Asia, western Pacific Ocean. Its four main islands are Hokkaido, Honshu, Shikoku, and Kyushu. It is separated from the Asian mainland by the Sea of Japan (East Sea). Area: 145,937 sq mi (377,975 sq km)."));
        countries.add(new Country(R.drawable.thailand, "Thailand", "Thailand, country located in the centre of mainland Southeast Asia. Located wholly within the tropics, Thailand encompasses diverse ecosystems, including the hilly forested areas of the northern frontier."));

        for (Country country : countries
        ) {
            original.add(country);
        }
        adapter = new CountryAdapter(countries, this);
        recyclerView.setAdapter(adapter);

        setupAutoComplete();
    }

    private void initializeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setupAutoComplete() {
        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, getCountryNames());
        countriesAutoComplete.setAdapter(autoCompleteAdapter);

        countriesAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountry = parent.getItemAtPosition(position).toString();
                filterRecyclerView(selectedCountry);
            }
        });

        countriesAutoComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    filterRecyclerView("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private List<String> getCountryNames() {
        List<String> countryNames = new ArrayList<>();
        for (Country country : countries) {
            countryNames.add(country.getName());
        }
        return countryNames;
    }

    private void filterRecyclerView(String selectedCountry) {
        countries.forEach(country -> System.out.println(country.getName()));
        if (selectedCountry.isEmpty()) {
            adapter.updateData(original);
        } else {
            List<Country> filteredCountries = new ArrayList<>();
            for (Country country : countries) {
                if (country.getName().equalsIgnoreCase(selectedCountry)) {
                    filteredCountries.add(country);
                }
            }
            System.out.println(filteredCountries.size());
            adapter.updateData(filteredCountries);
        }
    }
}