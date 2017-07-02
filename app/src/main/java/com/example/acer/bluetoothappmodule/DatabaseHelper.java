package com.example.acer.bluetoothappmodule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by acer on 7/1/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="smart_remote_db";
    public static final String TABLE_NAME_1="device_table";
    public static final String COL_1_1="id";
    public static final String COL_1_2="device_name";

    public static final String TABLE_NAME_2="command_table";
    public static final String COL_2_1="type";
    public static final String COL_2_2="serial_code";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_1="CREATE TABLE "+TABLE_NAME_1+" ("+COL_1_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_1_2+" TEXT)";
        db.execSQL(sql_1);
        String sql_2="CREATE TABLE "+TABLE_NAME_2+" ("+COL_1_1+" INTEGER, "+COL_2_1+" TEXT,"+COL_2_2+" TEXT, PRIMARY KEY("+COL_1_1+","+COL_2_1+"))";
        db.execSQL(sql_2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXITS "+TABLE_NAME_2);
        onCreate(db);
    }

    public boolean insertDevice(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1_2,name);
        long result=db.insert(TABLE_NAME_1,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getDevice(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM "+TABLE_NAME_1+" WHERE "+COL_1_1+"="+id+"",null);
        return result;
    }

    public int getDeviceId(){

        String countQuery = "SELECT  * FROM " + TABLE_NAME_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }

    public void deleteDevice(String device){
        String[] res=device.split(" ");
        String id=res[0];
        SQLiteDatabase db=this.getWritableDatabase();
        int res1=db.delete(TABLE_NAME_1,"id=?",new String[]{id});
        int res2=db.delete(TABLE_NAME_2,"id=?",new String[]{id});
        Log.d("Tag",String.valueOf(res1)+" "+String.valueOf(res2));

    }

    public Cursor getAllDevices(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM "+TABLE_NAME_1,null);
        return result;
    }

    public boolean updateDeviceName(String id,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1_1,id);
        values.put(COL_1_2,name);
        long result=db.update(TABLE_NAME_1,values,"id = ?",new String[]{ id });
        if(result==-1)
            return false;
        else
            return true;

    }

    public boolean insertCommand(String id,String type,String serial){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1_1,id);
        values.put(COL_2_1,type);
        values.put(COL_2_2,serial);
        long result=db.insert(TABLE_NAME_2,null,values);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getCommand(String id,String type){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("SELECT * FROM "+TABLE_NAME_2+" WHERE "+COL_1_1+"="+id+" and "+COL_2_1+"="+type+"",null);
        return result;

    }

    public boolean updateCommand(String id,String type,String serial){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1_1,id);
        values.put(COL_2_1,type);
        values.put(COL_2_2,serial);
        long result=db.update(TABLE_NAME_2,values,"id = ? and type = ?",new String[]{ id, type });
        if(result==-1)
            return false;
        else
            return true;

    }
}
