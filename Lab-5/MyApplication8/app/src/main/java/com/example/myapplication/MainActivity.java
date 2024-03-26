package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] array = {"Car","Bike"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextText);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,array);
        spinner.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(editText.getText().toString(),spinner.getSelectedItem().toString());
            }
        });

    }
    public void openActivity(String s1,String s2) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("Selectedtype",s1);
        intent.putExtra("details",s2);
        startActivity(intent);
    }
}