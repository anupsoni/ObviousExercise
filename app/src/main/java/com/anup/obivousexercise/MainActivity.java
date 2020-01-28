package com.anup.obivousexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private NotesAdapter mAdapter;
    DataBaseManipulate db;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        db = new DataBaseManipulate(context);
        recyclerView = (RecyclerView) findViewById(R.id.notes_list);

        mAdapter = new NotesAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListData();
    }

    private void getListData() {
        mAdapter.notifyDataSetChanged();
    }
}
