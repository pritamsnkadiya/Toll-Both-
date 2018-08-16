package com.example.pritam.fluidiot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class NearBy extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Mapbox.getInstance (this, getString (R.string.access_token));
        setContentView (R.layout.activity_near_by);

        mapView = (MapView) findViewById (R.id.mapView);
        mapView.onCreate (savedInstanceState);
        mapView.getMapAsync (new OnMapReadyCallback () {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                // Customize map with markers, polylines, etc.
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng (28.4595, 77.0266))
                        .title("Gurgaov!")
                        .snippet("Welcome to Gurgaov"));
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng (29.433456, 76.970157))
                        .title("Panipat!")
                        .snippet("Welcome to Panipat"));
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng (29.543047, 76.970283))
                        .title("Karnal!")
                        .snippet("Welcome to Karnal"));
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng (30.527493, 76.813255))
                        .title("Dappar!")
                        .snippet("Welcome to Dappar"));
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng (30.833909, 76.643899))
                        .title("Chandigarh!")
                        .snippet("Welcome to Chandigarh"));
            }
        });
    }

    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    protected void onStart() {
        super.onStart ();
        mapView.onStart ();
    }

    @Override
    public void onResume() {
        super.onResume ();
        mapView.onResume ();
    }

    @Override
    public void onPause() {
        super.onPause ();
        mapView.onPause ();
    }

    @Override
    protected void onStop() {
        super.onStop ();
        mapView.onStop ();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory ();
        mapView.onLowMemory ();
    }
}
