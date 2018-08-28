package com.hakon.stensheim.entprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    public void openGetHelp(View view) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        double latitude = Double.valueOf("59.9139");
        double longitude = Double.valueOf("10.7522");
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Din posisjon"));

        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(59.9139,
                        10.7522));
        CameraUpdate zoom= CameraUpdateFactory.zoomTo(13);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
}
