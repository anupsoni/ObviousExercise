package com.anup.obivousexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class NotesDetailsActivity extends AppCompatActivity {

    DataBaseManipulate db;
    Context context;
    String timestamp = "";
    TextView time,title,contentEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_details);
        context = NotesDetailsActivity.this;
        db = new DataBaseManipulate(context);
        timestamp = getIntent().getStringExtra("timestamp");  // selected timestamp to read that notes
        time = (TextView)findViewById(R.id.timestamp);
        title = (TextView)findViewById(R.id.title);
        contentEdit = (TextView)findViewById(R.id.content);
        Cursor cursor = db.getNotesDetails(timestamp);
        if(cursor.getCount()>0)
        {
            if(cursor.moveToFirst())
            {
                do{
                    String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
                    String contentTitle = cursor.getString(cursor.getColumnIndex("title"));
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    Calendar cal = Calendar.getInstance(Locale.ENGLISH);
                    cal.setTimeInMillis(Long.parseLong(timestamp));
                    String date = DateFormat.format("dd MMMM yyyy, h:mm:a", cal).toString();
                    time.setText(date);
                    title.setText(contentTitle);
                    contentEdit.setText(content);

                }while (cursor.moveToNext());
            }
        }
        cursor.close();
    }
}
