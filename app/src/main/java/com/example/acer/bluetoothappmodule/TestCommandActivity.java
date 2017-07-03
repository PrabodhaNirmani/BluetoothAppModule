package com.example.acer.bluetoothappmodule;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import static android.R.drawable.arrow_down_float;
import static android.R.drawable.arrow_up_float;
import static android.R.drawable.ic_lock_power_off;
import static android.R.drawable.ic_media_next;
import static android.R.drawable.ic_media_previous;

public class TestCommandActivity extends AppCompatActivity {
    private static final String TAG="TestCommandActivity";
    private String commandType;
    ImageButton command;
    TextView tvCmd;
    TextView tvSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_command);
        command=(ImageButton)findViewById(R.id.btn_command);
        tvCmd=(TextView)findViewById(R.id.tvCmd);
        tvSignal=(TextView)findViewById(R.id.tvMsg);
        Log.d(TAG,"testCom");
        checkCommand();

    }

    private void checkCommand(){
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        this.commandType=message;
        if(message.equals("increase")){
            Log.d(TAG,2+commandType);
            command.setImageResource(arrow_up_float);
            command.setBackgroundColor(Color.BLACK);
            tvCmd.setText("Increase Volume");

        }
        else if(message.equals("decrease")){
            Log.d(TAG,3+commandType);
            command.setImageResource(arrow_down_float);
            command.setBackgroundColor(Color.BLACK);
            tvCmd.setText("Decrease Volume");

        }else if(message.equals("on_off")){
            Log.d(TAG,1+commandType);
            command.setImageResource(ic_lock_power_off);
            command.setBackgroundColor(Color.RED);
            tvCmd.setText("Turn Off/On Remote");

        }else if(message.equals("forward")){
            Log.d(TAG,5+commandType);
            command.setImageResource(ic_media_next);
            command.setBackgroundColor(Color.BLACK);
            tvCmd.setText("Forward Channels");

        }else {
            Log.d(TAG,4+commandType);
            command.setImageResource(ic_media_previous);
            command.setBackgroundColor(Color.parseColor("#ffcc0000"));
            tvCmd.setText("Backward Channels");

        }



    }

    public void testCommand(View v){

        String signal=tvSignal.getText().toString();
        if(signal.equals("")){
            Toast.makeText(TestCommandActivity.this,"Please check your bluetooth connection is working",Toast.LENGTH_LONG).show();

        }
        else {
            //send signal and check that
        }

    }

    public void saveSignal(View v){
        String signal=tvSignal.getText().toString();
        if(signal.equals("")){
            Toast.makeText(TestCommandActivity.this,"Please check your bluetooth connection is working",Toast.LENGTH_LONG).show();

        }
        else {
            MainActivity.getDatabaseHelper().insertCommand(ConnectionActivity.getDeviceId(),commandType,signal);
        }

    }


}
