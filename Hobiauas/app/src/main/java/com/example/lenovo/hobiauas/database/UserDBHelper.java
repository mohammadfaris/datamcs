package com.example.lenovo.hobiauas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.lenovo.hobiauas.database.UserContract.NewUserInfo.Email;
import static com.example.lenovo.hobiauas.database.UserContract.NewUserInfo.Password;
import static com.example.lenovo.hobiauas.database.UserContract.NewUserInfo.TABLE_NAME;

import static com.example.lenovo.hobiauas.database.UserContract.NewUserInfo.first_name;

import static com.example.lenovo.hobiauas.database.UserContract.NewUserInfo.last_name;


/**
 * Created by lenovo on 12/23/2016.
 */

public class UserDBHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "hobia.db";
    private static final int DATABASE_VERSION = 1;
    String tag = "Database Operation";
    private static  final  String CREATE_QUERY = "CREATE TABLE "+TABLE_NAME +" ("+first_name+" varchar, "+last_name+" varchar, "+Email+" varchar, "+Password+" varchar)";

    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        Log.e(tag, "Database Created/ Opened ...");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e(tag,"Table Created ...");
    }
    public void addData(String firstname, String lastname, String email, String password,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(first_name,firstname);
        contentValues.put(last_name,lastname);
        contentValues.put(Email,email);
        contentValues.put(Password,password);
        db.insert(TABLE_NAME,null,contentValues);
        Log.e(tag,"One row Inserted successfully....");
    }
    public Cursor getInformation(SQLiteDatabase db){

        Cursor result;
        String [] Projections = {first_name,last_name,Email,Password};
        result = db.query(TABLE_NAME,Projections,null,null,null,null,null);


        return result;
    }

    

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
