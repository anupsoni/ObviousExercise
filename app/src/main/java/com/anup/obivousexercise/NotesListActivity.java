package com.anup.obivousexercise;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {
    private ArrayList<DataModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private NotesAdapter mAdapter;
    DataBaseManipulate db;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = NotesListActivity.this;
        db = new DataBaseManipulate(context);
        recyclerView = (RecyclerView) findViewById(R.id.notes_list);

        mAdapter = new NotesAdapter(context,list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        getListData();
    }

    private void getListData() {

        Cursor cursor = db.getNotesList();
        if(cursor.getCount()>0)
        {
            list.clear();
            if(cursor.moveToFirst())
            {
                do{
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
                    DataModel model = new DataModel(title,content,timestamp);
                    list.add(model);

                }while (cursor.moveToNext());
            }
        }
        cursor.close();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
