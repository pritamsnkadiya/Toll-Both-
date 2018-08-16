package com.example.pritam.fluidiot;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

public class PayToll extends AppCompatActivity {
    private MapView mapView;
    private Button pay;
    int cnt=0;
    ArrayAdapter<CharSequence> adapter;
    ListView listView1;
    CheckBox checkBox;
    TextView tv1,tv2,tv3;
    protected CharSequence[] receivers = { "Bhagan             65",
                                            "Panipat Elevated   30",
                                            "Gharaunda(Karnal) 115",
                                            "Dappar             35",
                                            "Total            246"};
    protected ArrayList<CharSequence> selectedReceivers = new ArrayList<> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Mapbox.getInstance (this, getString (R.string.access_token));
        setContentView (R.layout.activity_pay_toll);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        pay= (Button) findViewById (R.id.pay);
        listView1 = (ListView) findViewById (R.id.listView1);

        checkBox=(CheckBox)findViewById (R.id.checkBox);
        tv1=(TextView)findViewById (R.id.tName);
        tv2=(TextView)findViewById (R.id.price);
        tv3=(TextView)findViewById (R.id.tPrice);

        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_multiple_choice, selectedReceivers);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(adapter);

        pay.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.pay:
                        showSelectReceiversDialog();
                        break;
                    default:
                        break;
                }
            }
        });
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mapboxMap.addMarker(new MarkerOptions ()
                        .position(new LatLng(28.4595, 77.0266))
                        .title("Gurgaov !")
                        .snippet("Welcome to my City "));
            }
        });
    }
    protected void onChangeSelectedReceivers() {
        StringBuilder stringBuilder = new StringBuilder();

        for(CharSequence receivers : selectedReceivers)
            stringBuilder.append(receivers + ",");
        adapter.notifyDataSetChanged();
        //selectReceiversBtn.setText(stringBuilder.toString());
    }
    protected void showSelectReceiversDialog() {
        boolean[] checkedReceivers = new boolean[receivers.length];
        final int count = receivers.length;
       /* LayoutInflater inflater = getLayoutInflater ();
        View alertLayout = inflater.inflate (R.layout.dialogbox, null);*/

        for(int i = 0; i < count; i++){
            checkedReceivers[i] = selectedReceivers.contains (receivers[i]);
        }
        DialogInterface.OnMultiChoiceClickListener receiversDialogListener =
                new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked) {
                    selectedReceivers.add (receivers[which]);
                }
                else
                    selectedReceivers.remove(receivers[which]);
                cnt++;
                onChangeSelectedReceivers();
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
      //  builder.setView(alertLayout);
        builder
                .setTitle("Select Toll")
                .setMultiChoiceItems(receivers, checkedReceivers, receiversDialogListener)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dialog.dismiss();

                        Intent intent = new Intent (PayToll.this,CarsActivity.class);
                        intent.putExtra ("count",cnt);
                        startActivity (intent);
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

   /* public void show() {
        if (itemList.isEmpty()) {
            itemList.add(new item("A", 1));
            itemList.add(new item("B", 2));
            itemList.add(new item("C", 3));
        }

        final PayToll adapter =
                new PayToll(this, itemList);

        new AlertDialog.Builder().setTitle("Select Image")
                .setAdapter((ListAdapter) adapter, null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }*/
}