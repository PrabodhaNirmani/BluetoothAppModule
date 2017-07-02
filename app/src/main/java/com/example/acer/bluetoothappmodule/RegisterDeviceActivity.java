package com.example.acer.bluetoothappmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterDeviceActivity extends AppCompatActivity {

    private static final String TAG="RegisterDeviceActivity";
    private static int deviceId;
    Button saveDevice,next;
    EditText deviceName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_device);
        saveDevice=(Button)findViewById(R.id.buttonRegister);
        deviceName=(EditText)findViewById(R.id.etDeviceName);
        next=(Button)findViewById(R.id.btnNext);
    }


    public void addDevice(View v){
        Log.d(TAG,"save button pressed");
        Log.d(TAG,deviceName.getText().toString());

        if(deviceName.getText().toString().equals(new String("")))
            Toast.makeText(RegisterDeviceActivity.this,"Please make sure to fill the device name field",Toast.LENGTH_LONG).show();
        else{
            boolean inserted=MainActivity.getDatabaseHelper().insertDevice(deviceName.getText().toString());
            if(inserted){
                Toast.makeText(RegisterDeviceActivity.this,"Device registered",Toast.LENGTH_LONG).show();
                deviceName.setText("");
                finish();
                startActivity(new Intent(this, InstantiateDeviceActivity.class));


            }else {
                Toast.makeText(RegisterDeviceActivity.this,"Error occurred. Try again",Toast.LENGTH_LONG).show();

            }
        }

    }


}
