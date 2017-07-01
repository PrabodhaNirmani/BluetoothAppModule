package com.example.acer.bluetoothappmodule;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";

    private static DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);

    }

    public void onClickRegisterDevice(View v){

        Log.d(TAG,"Register button pressed");
        Intent i = new Intent(this,RegisterDeviceActivity.class);
        startActivity(i);
    }

    public static DatabaseHelper getDatabaseHelper(){
        return myDB;
    }
}
