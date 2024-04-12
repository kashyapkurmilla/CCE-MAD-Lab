package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    private ListView lv;
    private DBHelper db;
    ArrayList list = new ArrayList();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        lv = findViewById(R.id.listView);
        showlist();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String regno = lv.getAdapter().getItem(i).toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity7.class);
                intent.putExtra("regno",regno);
                startActivity(intent);
            }
        });

    }
    public void showlist()
    {
        db= new DBHelper(MainActivity6.this);
        list.clear();
        Cursor cursor = db.Showdata();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(MainActivity6.this, "No Data", Toast.LENGTH_SHORT).show();
        }
        while(cursor.moveToNext())
        {
            //list.add(cursor.getString(1));
            list.add(cursor.getString(2));
            //list.add(cursor.getString(3));
        }
        adapter = new ArrayAdapter(MainActivity6.this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
    }

}