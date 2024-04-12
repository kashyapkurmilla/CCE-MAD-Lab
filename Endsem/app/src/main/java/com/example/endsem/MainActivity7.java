package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

public class MainActivity7 extends AppCompatActivity {

    private DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent intent = getIntent();
        String regno = intent.getStringExtra("regno");
        dbhelper = new DBHelper(MainActivity7.this);
        showdata(regno);

    }
    public void showdata(String regno){
        dbhelper = new DBHelper(MainActivity7.this);
        Cursor maincursor = dbhelper.Showdata();
        if(maincursor == null){
            message("Error","No data");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(maincursor.moveToNext()) {
            if (maincursor.getString(2) .equals(regno)) {
                buffer.append("Id : " + maincursor.getString(0) + "\n").append("Name : " + maincursor.getString(1) + "\n").append("Regno : " + maincursor.getString(2) + "\n")
                        .append("Marks : " + maincursor.getInt(3) + "\n");
            }
            message("Data",buffer.toString());
        }
    }
    public void message(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title)
                .setMessage(message)
                .show();
    }
}