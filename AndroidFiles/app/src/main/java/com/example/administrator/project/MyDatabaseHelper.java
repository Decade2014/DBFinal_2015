package com.example.administrator.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 import android.content.ContentValues;
 import android.content.Context;
 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.database.sqlite.SQLiteOpenHelper;
 import android.util.Log;

 /**
 * Created by Administrator on 2015/11/25.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Contacts.db";
    public static final String TABLE_NAME = "Contacts";
    public static final String TABLE_NAME2 = "SouSuo";
    public static final int DB_VERSION = 1;
    public MyDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //bad
        Log.d("show:", "create a Databasexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        String CREATE_TABLE = "create table " + TABLE_NAME + "(_id integer primary key autoincrement,"+"no text not null,name text not null,tel text);";
        String CREATE_TABLE2 = "create table" + TABLE_NAME2 + "(_id integer primary key autoincrement,"+"first text not null,second text not null);";
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
        onCreate(db);
    }
    public long insert(Contact entity)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("no",entity.getNo());
        values.put("name",entity.getName());
        values.put("tel", entity.getTel());

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return  id;
    }
    public long insert2(String a,String b)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("first",a);
        values.put("second",b);
        long id = db.insert(TABLE_NAME2, null, values);
        db.close();
        return  id;
    }
    public int update(Contact entity)
    {
        SQLiteDatabase db = getWritableDatabase();
        String whereClaues = "no = ?";
        String []whereArgs = {entity.getNo()};

        ContentValues values = new ContentValues();
        values.put("no",entity.getNo());
        values.put("name",entity.getName());
        values.put("tel", entity.getTel());

        int rows = db.update(TABLE_NAME, values, whereClaues, whereArgs);
        db.close();
        return  rows;
    }
    public int delete(Contact entity)
    {
        SQLiteDatabase db = getWritableDatabase();
        String whereClaues = "no = ?";
        String []whereArgs = {entity.getNo()};

        int rows = db.delete(TABLE_NAME, whereClaues, whereArgs);
        db.close();
        return  rows;
    }
    public int empty()
    {
        Cursor c = query();
        if (c.moveToFirst() == false) return 1;
        else  return 0;
    }
    public Cursor query()
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.query(TABLE_NAME,null,null,null,null,null,null);
    }
}
