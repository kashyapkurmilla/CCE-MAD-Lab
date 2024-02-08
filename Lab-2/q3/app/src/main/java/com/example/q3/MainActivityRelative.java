package com.example.q3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityRelative extends AppCompatActivity {

    EditText textBox;
    Button submitButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        textBox = findViewById(R.id.text_box);
        submitButton = findViewById(R.id.submit_button);
        cancelButton = findViewById(R.id.cancel_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message
                showToast("Submit button clicked");
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the text box
                textBox.setText("");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(MainActivityRelative.this, message, Toast.LENGTH_SHORT).show();
    }
}
