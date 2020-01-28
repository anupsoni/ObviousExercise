package com.anup.obivousexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseManipulate db;
    Context context;
    EditText titleEdit,contentEdit;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        db = new DataBaseManipulate(context);
         titleEdit = (EditText)findViewById(R.id.title);
         contentEdit = (EditText)findViewById(R.id.content);
         save = (Button)findViewById(R.id.save);

         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String title = titleEdit.getText().toString();
                 String content = contentEdit.getText().toString();
                 if(title.equals("")){
                     Toast.makeText(context,"title is empty",Toast.LENGTH_LONG).show();
                 }else if(content.equals("")){
                     Toast.makeText(context,"content is empty",Toast.LENGTH_LONG).show();
                 }else{
                     ContentValues cv = new ContentValues();
                     cv.clear();
                     cv.put("title",title);
                     cv.put("content",content);
                     cv.put("timestamp",String.valueOf(System.currentTimeMillis()));
                     long status = db.InsertData(DataBaseManipulate.TABLE_NOTES_DETAILS,cv,"id");
                     if (status > 0){
                         Toast.makeText(context,"Notes inserted successfully",Toast.LENGTH_LONG).show();
                     }else{
                         Toast.makeText(context,"Notes inserted failed",Toast.LENGTH_LONG).show();
                     }
                 }
             }
         });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
