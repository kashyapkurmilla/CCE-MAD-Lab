package com.example.lab4_4;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageView imageView1;
    Button clickme_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        imageView1 = findViewById(R.id.imageView1);
        clickme_button = findViewById(R.id.clickme_button);

        imageView1.setImageResource(R.drawable.ringing_image);
        toggleButton.setChecked(false);
        toggleButton.setTextOff("Ringing");
        toggleButton.setTextOn("Silent");

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView1.setImageResource(R.drawable.silent_image);
            }
            else {
                imageView1.setImageResource(R.drawable.ringing_image);
            }
        });
        clickme_button.setOnClickListener(v -> {
            String state = toggleButton.isChecked() ? "Ringing" : "Silent";
            if(state.equalsIgnoreCase("Ringing"))
            {
                toggleButton.setChecked(false);
            }
            else
            {
                toggleButton.setChecked(true);
            }
            Toast toast = Toast.makeText(getApplicationContext(), state + " mode activated", Toast.LENGTH_SHORT);
            toast.show();
        });
    }
}