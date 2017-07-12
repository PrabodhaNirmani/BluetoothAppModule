package com.example.acer.bluetoothappmodule;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.nio.charset.Charset;

public class InstantiateRemoteActivity extends AppCompatActivity {
    private static final String TAG="RemoteAvtivity";
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
        String cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"increase");

        if(cursor==null){
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "increase");
                intent.putExtra("type","insert");
                startActivity(intent);

            }
            else {
                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
            }

        }
        else {
            //do next task
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "increase");
                intent.putExtra("type","update");
                startActivity(intent);

            }
            else {
               // String signal=cursor.getString(3);

                byte[] bytes=cursor.getBytes(Charset.defaultCharset());
                ConnectionActivity.mBluetoothConnection.write(bytes);
            }

        }
//        if(ConnectionActivity.getViewId().equals("0")){
//
//            Intent intent = new Intent(this, TestCommandActivity.class);
//            intent.putExtra("message", "increase");
//            intent.putExtra("type","update");
//            intent.putExtra("type","insert");
//            startActivity(intent);
//
//        }
//        else {
//            Log.d(TAG,"increase signal sent");
//            Cursor cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"increase");
//            //sending signal
//            if(cursor==null){
//                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
//            }
//            else {
//                //do next task
//                String signal=cursor.getString(2);
//                byte[] bytes=signal.getBytes(Charset.defaultCharset());
//                ConnectionActivity.mBluetoothConnection.write(bytes);
//            }
//        }



    }

    public void saveDecrease(View v){
        String cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"decrease");

        if(cursor==null){
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "decrease");
                intent.putExtra("type","insert");
                startActivity(intent);

            }
            else {
                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
            }

        }
        else {
            //do next task
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "decrease");
                intent.putExtra("type","update");
                startActivity(intent);

            }
            else {
               // String signal=cursor.getString(3);

                byte[] bytes=cursor.getBytes(Charset.defaultCharset());
                ConnectionActivity.mBluetoothConnection.write(bytes);
            }

        }
//        if(ConnectionActivity.getViewId().equals("0")) {
//            Intent intent = new Intent(this, TestCommandActivity.class);
//            intent.putExtra("message", "decrease");
//            startActivity(intent);
//        }
//        else {
//            Log.d(TAG,"decrease signal sent");
//            Cursor cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"decrease");
//            //sending signal
//            if(cursor==null){
//                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
//            }
//            else {
//                //do next task
//                String signal=cursor.getString(2);
//                byte[] bytes=signal.getBytes(Charset.defaultCharset());
//                ConnectionActivity.mBluetoothConnection.write(bytes);
//            }
//        }
    }
    public void saveForward(View v){
        String cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"forward");

        if(cursor==null){
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "forward");
                intent.putExtra("type","insert");
                startActivity(intent);

            }
            else {
                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
            }

        }
        else {
            //do next task
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "forward");
                intent.putExtra("type","update");
                startActivity(intent);

            }
            else {
               // String signal=cursor.getString(3);

                byte[] bytes=cursor.getBytes(Charset.defaultCharset());
                ConnectionActivity.mBluetoothConnection.write(bytes);
            }

        }
//        if(ConnectionActivity.getViewId().equals("0")) {
//            Intent intent = new Intent(this, TestCommandActivity.class);
//            intent.putExtra("message", "forward");
//            startActivity(intent);
//        }
//        else {
//            Log.d(TAG,"forward signal sent");
//            Cursor cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"forward");
//         //sending signal
//            if(cursor==null){
//                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
//            }
//            else {
//                //do next task
//                String signal=cursor.getString(2);
//                byte[] bytes=signal.getBytes(Charset.defaultCharset());
//                ConnectionActivity.mBluetoothConnection.write(bytes);
//            }
//        }
    }
    public void saveBackward(View v){
        String cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"backward");

        if(cursor==null){
            Log.d(TAG,ConnectionActivity.getViewId());
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "backward");
                intent.putExtra("type","insert");
                startActivity(intent);

            }
            else {
                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
            }

        }
        else {
            //do next task
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "backward");
                intent.putExtra("type","update");
                startActivity(intent);

            }
            else {
               // String signal=cursor.getString(3);

                byte[] bytes=cursor.getBytes(Charset.defaultCharset());
                ConnectionActivity.mBluetoothConnection.write(bytes);
            }

        }
//        if(ConnectionActivity.getViewId().equals("0")){
//            Intent intent = new Intent(this, TestCommandActivity.class);
//            intent.putExtra("message", "backward");
//            startActivity(intent);
//
//        }
//        else {
//            Log.d(TAG,"backward signal sent");
//            Cursor cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"backward");
//            //sending signal
//            if(cursor==null){
//                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
//            }
//            else {
//                //do next task
//                String signal=cursor.getString(2);
//                byte[] bytes=signal.getBytes(Charset.defaultCharset());
//                ConnectionActivity.mBluetoothConnection.write(bytes);
//            }
//        }

    }
    public void saveOnOff(View v){
        String cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"on_off");

        if(cursor==null){
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "on_off");
                intent.putExtra("type","insert");
                startActivity(intent);

            }
            else {
                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
            }

        }
        else {
            //do next task
            if(ConnectionActivity.getViewId().equals("0")){
                Intent intent = new Intent(this, TestCommandActivity.class);
                intent.putExtra("message", "on_off");
                intent.putExtra("type","update");
                startActivity(intent);

            }
            else {
               // String signal=cursor.getString(3);

                byte[] bytes=cursor.getBytes(Charset.defaultCharset());
                ConnectionActivity.mBluetoothConnection.write(bytes);
            }

        }
//        if(ConnectionActivity.getViewId().equals("0")){
//            Intent intent = new Intent(this, TestCommandActivity.class);
//            intent.putExtra("message", "on_off");
//            startActivity(intent);
//        }
//        else {
//            //sending signal
//            Log.d(TAG,"on off signal sent");
//            Cursor cursor=MainActivity.getDatabaseHelper().getCommand(ConnectionActivity.getDeviceId(),"on_off");
//            if(cursor==null){
//                Toast.makeText(InstantiateRemoteActivity.this,"Error occurred. try again",Toast.LENGTH_LONG).show();
//            }
//            else {
//                //do next task
//                String signal=cursor.getString(2);
//                byte[] bytes=signal.getBytes(Charset.defaultCharset());
//                ConnectionActivity.mBluetoothConnection.write(bytes);
//            }
//        }

    }



}
