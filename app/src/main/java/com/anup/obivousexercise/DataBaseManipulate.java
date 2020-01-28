package com.anup.obivousexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DataBaseManipulate extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "obivous_db";

    // Login table name
    public static final String TABLE_NOTES_DETAILS = "notes_table";

    SQLiteDatabase sd;

    public DataBaseManipulate(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sd=this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_LOGIN="CREATE TABLE "+TABLE_NOTES_DETAILS+"(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT," +
                "title TEXT,content TEXT)";
        db.execSQL(CREATE_TABLE_LOGIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES_DETAILS);
        // Create tables again
        onCreate(db);
    }


    public long InsertData(String tablename, ContentValues cv, String whereclm) {
        long a = sd.insert(tablename, whereclm, cv);
        return a;

    }
    public Cursor getNotesList(){
        sd=this.getWritableDatabase();
        String query="SELECT * from "+ TABLE_NOTES_DETAILS;
        Cursor c=  sd.rawQuery(query,null);
        return  c;
    }

}
