package com.finaannisarahmasari.tugassensor2023akbif_510120179;

//NIM  : 10120179
//Nama : Fina Annisa Rahmasari
//Kelas: IF-5

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.finaannisarahmasari.tugassensor2023akbif_510120179.databinding.ActivityMyLocationBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
public class MyLocationActivity extends FragmentActivity {

    private ActivityMyLocationBinding binding;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        client = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_maps);

        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MyLocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasi = new LatLng(location.getLatitude(),location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Anda Saat Ini");
                            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi,17));
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }

}