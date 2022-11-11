package com.example.sunhacks_patch1;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sunhacks_patch1.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;
    List<LatLng> list;
    private static final int request_code=101;
    double lat,lng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        list = new ArrayList<LatLng>();

//        StringBuilder stringBuilder =  new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
//        stringBuilder.append("location="+lat+","+lng);
//        stringBuilder.append("&radius=1000");
//        stringBuilder.append("type=hospital");
//        stringBuilder.append("&sensor=true");
//        stringBuilder.append("&key="+getResources().getString(R.string.API_KEY));
//
//
//        String url = stringBuilder.toString();
//        Object[] dataFetch = new Object[2];
//        dataFetch[0] = mMap;
//        dataFetch[1] = url;
//
//        FetchData fetchData =  new FetchData();
//        fetchData.execute(dataFetch);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getCurrentLocation();

        list.add(new LatLng(19.9047,73.4719));
        list.add(new LatLng(19.9412,73.7486));
        list.add(new LatLng(20.1122,73.7674));
        list.add(new LatLng(20.022372,73.720111));

        for(int i =0;i<list.size();i++)
        {
            addMarkerToMap(list.get(i));

        }

    }

    public void  addMarkerToMap(LatLng latLng)
    {
        MarkerOptions markerOptions =  new MarkerOptions();
//        markerOptions.title()
        mMap.addMarker(markerOptions.position(latLng));
    }
    private void getCurrentLocation()
    {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},request_code);

            return;
            }
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(60000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(5000);

        LocationCallback locationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                //Toast.makeText(MapsActivity.this, "Location Result is = "+locationResult, Toast.LENGTH_SHORT).show();
                if(locationResult == null)
                {
                    Toast.makeText(MapsActivity.this, "Current location is null", Toast.LENGTH_SHORT).show();
                }

                for(Location location : locationResult.getLocations())
                {
                    if(location!=null)
                    {
                        //Toast.makeText(MapsActivity.this, "Location Result is = "+location.getLatitude(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,null);

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null)
                {
                    lat = location.getLatitude();
                    lng = location.getLongitude();

                    LatLng latLng = new LatLng(lat,lng);
                    Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).title("Current Location"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                    marker.showInfoWindow();
                }
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case request_code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getCurrentLocation();
                }
        }
    }
}
