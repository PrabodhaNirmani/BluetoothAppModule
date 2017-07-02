package com.example.acer.bluetoothappmodule;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstantiateDeviceActivity extends AppCompatActivity {
    private ArrayList<String> deviceList=new ArrayList<>();
    private static final String TAG="InstantiateDevices";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instantiate_device);
        ListView listView = (ListView) findViewById(R.id.device_list);
        Log.d(TAG,"before generate list content");
        generateListContent();
        listView.setAdapter(new MyListAdapter(this,R.layout.activity_device_item,this.deviceList));


    }

    private void generateListContent(){
        Log.d(TAG,"inside generate list content");
        Cursor cursor=MainActivity.getDatabaseHelper().getAllDevices();
        if(cursor==null){
            Log.d(TAG,"null");
        }
        else {
            Log.d(TAG,"else");
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                deviceList.add(cursor.getString(0)+" "+cursor.getString(1));
            }
            cursor.close();
        }

    }

    public InstantiateDeviceActivity getInstance(){
        return this;
    }


    public void addDevicePressed(View v){
        Intent i = new Intent(this,RegisterDeviceActivity.class);
        startActivity(i);
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
                viewHolder.deleteButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        MainActivity.getDatabaseHelper().deleteDevice(viewHolder.deviceName.getText().toString());
                        finish();
                        startActivity(getIntent());
                    }

                });

                viewHolder.deviceName.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent j = new Intent(getInstance(),ConnectionActivity.class);
                        startActivity(j);
                    }
                });

                viewHolder.imageView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent j = new Intent(getInstance(),ConnectionActivity.class);
                        startActivity(j);


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