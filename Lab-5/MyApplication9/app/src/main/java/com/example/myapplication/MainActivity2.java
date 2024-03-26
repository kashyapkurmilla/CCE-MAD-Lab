package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;
import android.widget.TimePicker;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);

        String s1, s2, s3, s4, s5; // Existing timings
        s2 = getIntent().getStringExtra("To");
        s1 = getIntent().getStringExtra("from");
        s3 = getIntent().getStringExtra("way");
        s4 = getIntent().getStringExtra("Date");
        s5 = getIntent().getStringExtra("Time");
        textView.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5);
        String[] s= s5.split(":");
        String ss=s[1];
        String sd = s[0];
        int hour = Integer.parseInt(sd);
        int minute = Integer.parseInt(ss);
        int ss1 = minute+15;
        int ss2 = minute+30;
        textView3.setText(String.valueOf(hour)+":"+String.valueOf(minute)+","+String.valueOf(hour)+":"+String.valueOf(minute+15)+","+String.valueOf(hour)+":"+String.valueOf(minute+30));
    }
}
