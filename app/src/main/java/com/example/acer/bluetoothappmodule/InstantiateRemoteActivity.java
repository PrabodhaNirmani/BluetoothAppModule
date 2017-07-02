package com.example.acer.bluetoothappmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InstantiateRemoteActivity extends AppCompatActivity {

    ImageButton increase;
    ImageButton decrease;
    ImageButton forward;
    ImageButton backward;
    ImageButton on_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instantiate_remote);
        increase=(ImageButton)findViewById(R.id.btn_increase);
        decrease=(ImageButton)findViewById(R.id.btn_decrease);
        forward=(ImageButton)findViewById(R.id.btn_forward);
        backward=(ImageButton)findViewById(R.id.btn_backward);
        on_off=(ImageButton)findViewById(R.id.btn_on_off);


    }

    public void saveIncrease(View v){
        Intent intent = new Intent(this, TestCommandActivity.class);
        intent.putExtra("message", "increase");
        startActivity(intent);

    }

    public void saveDecrease(View v){
        Intent intent = new Intent(this, TestCommandActivity.class);
        intent.putExtra("message", "decrease");
        startActivity(intent);

    }
    public void saveForward(View v){
        Intent intent = new Intent(this, TestCommandActivity.class);
        intent.putExtra("message", "forward");
        startActivity(intent);

    }
    public void saveBackward(View v){
        Intent intent = new Intent(this, TestCommandActivity.class);
        intent.putExtra("message", "backward");
        startActivity(intent);

    }
    public void saveOnOff(View v){
        Intent intent = new Intent(this, TestCommandActivity.class);
        intent.putExtra("message", "on_off");
        startActivity(intent);

    }



}
