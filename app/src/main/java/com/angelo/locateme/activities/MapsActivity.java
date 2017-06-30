package com.angelo.locateme.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.angelo.locateme.R;
import com.angelo.locateme.fragments.MainFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;


public class MapsActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, com.google.android.gms.location.LocationListener {

    private GoogleApiClient mgoogleApiClient;
    final int PERMISSION_LOCATION = 111;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

         mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.container_main);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.container_main, mainFragment).commit();
        }

        mgoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addConnectionCallbacks(this).addApi(LocationServices.API).build();
    }

    @Override
    protected void onStart() {
        mgoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mgoogleApiClient.disconnect();
        super.onStop();
    }

    public void startLocationServices() {
        Log.v("MAPS:", "Starting Location Services Called");

        try {
            LocationRequest req = LocationRequest.create().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            LocationServices.FusedLocationApi.requestLocationUpdates(mgoogleApiClient, req, this);

            Log.v("DONKEY: ","REQUESTING LOCATION UPDATES");
        } catch (SecurityException ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            Log.v("DONKEY: ", ex.toString().toUpperCase());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startLocationServices();
                    Log.v("DONKEY: ","PERMISSION GRANTED - STARTING SERVICES" );
                } else {
                    Toast.makeText(this, "Location wasn't given access.", Toast.LENGTH_SHORT).show();
                    Log.v("DONKEY: ","PERMISSION NOT GRANTED" );
                }
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION);
            Log.v("DONKEY: ", "REQUESTING PERMISSION");
        } else {
            startLocationServices();
            Log.v("DONKEY: ", "Starting Location Services from onConnected".toUpperCase());
            Toast.makeText(this, "Starting Location Services from onConnected", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void onLocationChanged(Location location) {
        Log.v("DONKEY: ", "Longitude: "+ location.getLongitude() + " Latitude: " + location.getLatitude());
        mainFragment.setMarker(new LatLng(location.getLatitude(),location.getLongitude()));

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onConnectionSuspended(int i) {

    }


}
