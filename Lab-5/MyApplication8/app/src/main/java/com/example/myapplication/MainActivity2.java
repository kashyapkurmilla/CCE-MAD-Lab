package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView2);
        String s1 = getIntent().getStringExtra("Selectedtype");
        String s2 = getIntent().getStringExtra("details");
        textView.setText(getIntent().getStringExtra("Selectedtype"));
        textView1.setText(getIntent().getStringExtra("details"));
        Button button = findViewById(R.id.button2);
        Button button1 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtoMain();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num++;
                Toast.makeText(MainActivity2.this,String.valueOf(num)+"."+s1 + " " + s2,Toast.LENGTH_LONG).show();
            }
        });


    }
    public void backtoMain()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}