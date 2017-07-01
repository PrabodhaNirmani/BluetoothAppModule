package com.example.acer.bluetoothappmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class RegisterDeviceActivity extends AppCompatActivity {

    private static final String TAG="RegisterDeviceActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_device);
    }

    public void saveButtonPressed(){
        Log.d(TAG,"save button pressed");
    }


}
