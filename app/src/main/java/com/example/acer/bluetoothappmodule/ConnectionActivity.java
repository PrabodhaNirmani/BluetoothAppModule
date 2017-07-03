package com.example.acer.bluetoothappmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConnectionActivity extends AppCompatActivity {

    private static String deviceId;
    private static String viewId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        Bundle bundle = getIntent().getExtras();
        deviceId = bundle.getString("id").split(" ")[0];
        viewId = bundle.getString("id").split(" ")[1];
    }

    public void saveCommands(View v){
        Intent j = new Intent(this,InstantiateRemoteActivity.class);
        startActivity(j);
    }

    public static String getDeviceId(){
        return deviceId;
    }

    public static String getViewId(){
        return  viewId;
    }
}
