package com.example.acer.bluetoothappmodule;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstantiateDeviceActivity extends AppCompatActivity {
    private ArrayList<String> deviceList=new ArrayList<>();
    private static final String TAG="InstantiateDevices";
    private static String viewId;
    private ImageButton btnAdd;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instantiate_device);
        ListView listView = (ListView) findViewById(R.id.device_list);
        Log.d(TAG,"before generate list content");

        listView.setAdapter(new MyListAdapter(this,R.layout.activity_device_item,this.deviceList));
        Bundle bundle = getIntent().getExtras();
        viewId = bundle.getString("viewId");
        Log.d(TAG,viewId);
        btnAdd=(ImageButton)findViewById(R.id.btnAdd);


        if (viewId.equals("1")){
            btnAdd.setVisibility(View.INVISIBLE);
            generateFinalizedlistItems();
            if(deviceList.size()==0){
                Toast.makeText(InstantiateDeviceActivity.this,"No devices registered yet. Register first",Toast.LENGTH_LONG).show();
                finish();
            }

        }
        else {
            btnAdd.setVisibility(View.VISIBLE);
            generateListContent();
        }


    }

//    @Override
//    public void onStart(){
//        super.onStart();
//       // generateListContent();
//    }
    @Override
    public void onPause(){
        super.onPause();
        deviceList.clear();
    }

//    @Override
//    public void onResume(){
//        super.onResume();
//        generateListContent();
//    }
    private void generateListContent(){
        Log.d(TAG,"inside generate list content");
        Cursor cursor=MainActivity.getDatabaseHelper().getAllDevices();
        if(cursor==null){
            Log.d(TAG,"null");
        }
        else {
            Log.d(TAG,"else");
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                String line=cursor.getString(0)+" "+cursor.getString(1);

                Log.d(TAG,line);
                deviceList.add(line);
            }
            cursor.close();
        }

    }

    public void generateFinalizedlistItems(){
        Log.d(TAG,"inside generate list content");
        Cursor cursor=MainActivity.getDatabaseHelper().getAllDevices();
        if(cursor==null){
            Log.d(TAG,"null");
        }
        else {
            Log.d(TAG,"else");
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                String devId=cursor.getString(0);
                String devName=cursor.getString(1);
                String line=devId+" "+devName;
                boolean finished=MainActivity.getDatabaseHelper().confirmRegistration(devId);
                if(finished){
                    Log.d(TAG,line);
                    deviceList.add(line);
                }


            }
            cursor.close();
        }

    }

    public InstantiateDeviceActivity getInstance(){
        return this;
    }


    public void addDevicePressed(View v){
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                Log.d(TAG,userInput.getText().toString());
                                if(userInput.getText().toString().equals(new String("")))
                                    Toast.makeText(InstantiateDeviceActivity.this,"Please make sure to fill the device name field",Toast.LENGTH_LONG).show();
                                else{
                                    boolean inserted=MainActivity.getDatabaseHelper().insertDevice(userInput.getText().toString());
                                    if(inserted){
                                        Toast.makeText(InstantiateDeviceActivity.this,"Device registered",Toast.LENGTH_LONG).show();
//                                        userInput.setText("");
                                        Intent intent = getIntent();
                                        finish();
//

                                        intent.putExtra("viewId", "0");
                                        startActivity(intent);



                                    }else {
                                        Toast.makeText(InstantiateDeviceActivity.this,"Error occurred. Try again",Toast.LENGTH_LONG).show();

                                    }
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    private class MyListAdapter extends ArrayAdapter<String>{

        private int layout;

        public MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            this.layout=resource;
        }


        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            ViewHolder mainViewHolder=null;
            if(convertView==null){
                LayoutInflater inflater=LayoutInflater.from(getContext());
                convertView=inflater.inflate(layout,parent,false);
                final ViewHolder viewHolder=new ViewHolder();
                viewHolder.imageView=(ImageView)convertView.findViewById(R.id.ivDevice);
                viewHolder.deviceName=(TextView)convertView.findViewById(R.id.tvDeviceName);
                viewHolder.deleteButton=(ImageButton)convertView.findViewById(R.id.btnDelete);
                viewHolder.deviceName.setText(deviceList.get(position));
                viewHolder.deleteButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        MainActivity.getDatabaseHelper().deleteDevice(viewHolder.deviceName.getText().toString());
                        Intent intent=getIntent();
                        finish();
                        intent.putExtra("viewId", "0");
                        startActivity(intent);
                    }

                });

                viewHolder.deviceName.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(getInstance(),ConnectionActivity.class);
                        intent.putExtra("id", viewHolder.deviceName.getText().toString()+" "+viewId);
                        startActivity(intent);
                    }
                });

                viewHolder.imageView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(getInstance(),ConnectionActivity.class);
                        intent.putExtra("id", viewHolder.deviceName.getText().toString()+" "+viewId);
                        startActivity(intent);


                    }
                });
                convertView.setTag(viewHolder);
            }
            else {
                mainViewHolder=(ViewHolder)convertView.getTag();
                mainViewHolder.deviceName.setText(getItem(position));
            }
            return convertView;
        }
    }

    public class ViewHolder{
        ImageView imageView;
        TextView deviceName;
        ImageButton deleteButton;
    }


}