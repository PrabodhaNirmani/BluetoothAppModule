package com.example.acer.bluetoothappmodule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by acer on 7/1/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABAE_NAME="smart_remote.db";
    public static final String TABLE_NAME="device_table";
//    public static final String


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
