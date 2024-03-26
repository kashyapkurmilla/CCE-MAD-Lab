package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView2);
        String s1,s2,s3,s4;
        s2=getIntent().getStringExtra("To");
        s1=getIntent().getStringExtra("from");
        s3=getIntent().getStringExtra("way");
        s4=getIntent().getStringExtra("Date");
        textView.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4);
    }
}