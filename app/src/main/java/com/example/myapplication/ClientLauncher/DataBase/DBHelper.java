package com.example.myapplication.ClientLauncher.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 12;
    public static final String DATABASE_NAME = "Talos_DB";
    public static final String TABLE_USER = "user";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_PASSWORD = "password";

    public static final String PERMISSIONS = "permissions";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USER + "(" + KEY_ID + " integer primary key," + KEY_NAME + " text," + KEY_MAIL + " text,"+  KEY_PASSWORD + " text," + PERMISSIONS + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USER);
        onCreate(db);
    }

}
