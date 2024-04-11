package com.example.endsem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private DBHelper dbhelper;
    private EditText edttxt;
    private Button submit,backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dbhelper = new DBHelper(MainActivity3.this);
        //showdata();
        edttxt =findViewById(R.id.editText1);
        submit=findViewById(R.id.submit);
        backbtn = findViewById(R.id.backbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regno=edttxt.getText().toString();
                showdata(regno);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void showdata(String regno){
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