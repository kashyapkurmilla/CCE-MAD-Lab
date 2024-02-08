package com.example.q3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonRelative, buttonLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRelative = findViewById(R.id.buttonrelative);
        buttonLinear = findViewById(R.id.buttonlinear);

        buttonRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the RelativeActivity
                Intent intent = new Intent(MainActivity.this, MainActivityRelative.class);
                startActivity(intent);
            }
        });

        buttonLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the FirstActivity (assuming "first" is the name of the layout)
                Intent intent = new Intent(MainActivity.this, first.class);
                startActivity(intent);
            }
        });
    }
}
