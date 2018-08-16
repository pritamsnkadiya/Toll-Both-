package com.example.pritam.fluidiot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CarsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView imageView;
    ImageButton btn_paytm,btn_mastercard,btn_bank,btn_american;
    EditText editText;
   // String EditTextValue ;
    Thread thread ;
    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;
    ProgressBar simpleProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cars);
        spinner = (Spinner) findViewById(R.id.spinner);

        imageView = (TextView) findViewById(R.id.imageView);
       // editText = (EditText)findViewById(R.id.editText);
        btn_paytm = (ImageButton) findViewById (R.id.paytm);
        btn_mastercard = (ImageButton) findViewById (R.id.mastercard);
        btn_bank = (ImageButton) findViewById (R.id.bank);
        btn_american = (ImageButton) findViewById (R.id.american);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        final int count=getIntent ().getIntExtra ("count",0);
        Log.d ("count is",count+"");
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String> ();
        categories.add("");
        categories.add("Alto");
        categories.add("Swift");
        categories.add("Brezza");
        categories.add("Bmw");
        categories.add("Safari");
        categories.add("Mazda");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        btn_paytm.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
               // EditTextValue = editText.getText().toString();
                simpleProgressBar.setVisibility (View.VISIBLE);
                simpleProgressBar.getProgressDrawable ();
                final ProgressDialog dialog = ProgressDialog.show (CarsActivity.this, "Doing something",
                        "Please wait....", true);
                new Thread (new Runnable () {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep (2000);
                            dialog.dismiss ();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace ();
                        }
                    }
                }).start ();
                try {
                    bitmap = TextToImageEncode("ass");
                    /*imageView.setImageBitmap(bitmap);*/
                    imageView.setText ("Payment Done !");
                    Timer timer =new Timer (false);
                    timer.schedule (new TimerTask () {
                        @Override
                        public void run() {
                            runOnUiThread (new Runnable () {
                                @Override
                                public void run() {
                                    imageView.setVisibility (View.INVISIBLE);
                                }
                            });
                        }
                    },8000);
                    imageView.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (CarsActivity.this,MainActivity.class);
                            try {
                                // your bitmap
                                Log.d ("Bittt",bitmap+"");
                                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
                                intent.putExtra("byteArray", bs.toByteArray());
                                Log.d ("byte",bs.toByteArray ()+"");
                                intent.putExtra ("count",count);
                                startActivity (intent);
                            }catch (Exception e){
                                Log.d ("Exception ",e.getMessage ()+"");
                            }
                        }
                    });

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_bank.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
               // EditTextValue = editText.getText().toString();
                try {
                    bitmap = TextToImageEncode("hj");
                    /*imageView.setImageBitmap(bitmap);*/
                    imageView.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (CarsActivity.this,MainActivity.class);
                            try {
                                // your bitmap
                                Log.d ("Bittt",bitmap+"");
                                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
                                intent.putExtra("byteArray", bs.toByteArray());
                                startActivity (intent);

                            }catch (Exception e){
                                Log.d ("Exception ",e.getMessage ()+"");
                            }
                        }
                    });

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_mastercard.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
               // EditTextValue = editText.getText().toString();
                try {
                    bitmap = TextToImageEncode("jd");
                    /*imageView.setImageBitmap(bitmap);*/
                    imageView.setOnClickListener (new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (CarsActivity.this,MainActivity.class);
                            try {
                                // your bitmap
                                Log.d ("Bittt",bitmap+"");
                                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
                                intent.putExtra("byteArray", bs.toByteArray());
                                Log.d ("byte",bs.toByteArray ()+"");
                                startActivity (intent);
                            }catch (Exception e){
                                Log.d ("Exception ",e.getMessage ()+"");
                            }
                        }
                    });
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_american.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //EditTextValue = editText.getText().toString();
                try {
                    bitmap = TextToImageEncode("jsa");

                    /*imageView.setImageBitmap(bitmap);*/
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter ().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null);

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.QRCodeBlackColor):getResources()
                        .getColor(R.color.QRCodeWhiteColor);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
