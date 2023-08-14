package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private double countryLatitude;
    private double countryLongitude;
    private String countryName;

    public MapsFragment(double latitude, double longitude, String countryName) {
        this.countryLatitude = latitude;
        this.countryLongitude = longitude;
        this.countryName = countryName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setOnMapClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng countryLatLng = new LatLng(countryLatitude, countryLongitude);
        mMap.addMarker(new MarkerOptions().position(countryLatLng).title(this.countryName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(countryLatLng, 5));
    }

    @Override
    public void onMapClick(LatLng point) {
        Intent intent = new Intent(getContext(), PredictedWeather.class);
        intent.putExtra("lat", point.latitude);
        intent.putExtra("lon", point.longitude);
        startActivity(intent);
    }
}