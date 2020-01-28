package com.anup.obivousexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DataBaseManipulate extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "obivous_db";

    // Database table name
    public static final String TABLE_NOTES_DETAILS = "notes_table";

    // Database table column name
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_TIMESTAMP = "timestamp";
    SQLiteDatabase sd;

    public DataBaseManipulate(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        sd=this.getWritableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES_DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TITLE + " TEXT," + KEY_CONTENT + " TEXT,"+ KEY_TIMESTAMP +
                " TEXT"+");";
        db.execSQL(CREATE_NOTES_TABLE);
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
        String query="SELECT * from "+ TABLE_NOTES_DETAILS + " order by id DESC";   // reverse order
        Cursor c=  sd.rawQuery(query,null);
        return  c;
    }
    public Cursor getNotesDetails(String timestamp){
        sd=this.getWritableDatabase();
        String query="SELECT * from "+ TABLE_NOTES_DETAILS + " WHERE "+ KEY_TIMESTAMP + "='"+timestamp+"'";
        Cursor c=  sd.rawQuery(query,null);
        return  c;
    }

}
