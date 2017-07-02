package com.example.acer.bluetoothappmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TestCommandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_command);
        Log.d("com","testCom");
        checkCommand();
    }

    private void checkCommand(){
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        if(message.equals("increase")){
            Log.d("com",2+message);

        }
        else if(message.equals("decrease")){
            Log.d("com",3+message);

        }else if(message.equals("on_off")){
            Log.d("com",1+message);

        }else if(message.equals("forward")){
            Log.d("com",5+message);

        }else {
            Log.d("com",4+message);

        }



    }
}
