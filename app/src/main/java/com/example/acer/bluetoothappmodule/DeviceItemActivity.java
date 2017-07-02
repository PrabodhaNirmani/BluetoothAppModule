package com.example.acer.bluetoothappmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeviceItemActivity extends AppCompatActivity {

    TextView device;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_item);
        device=(TextView)findViewById(R.id.tvDeviceName);
    }


}
