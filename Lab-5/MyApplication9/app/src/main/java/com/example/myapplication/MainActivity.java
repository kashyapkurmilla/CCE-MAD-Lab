package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.Toast;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    Button button;
    Button buttontime;
    TextView textView;
    TextView textViewtime;
    String[] places= {"Mumbai","Hyderabad","Bengaluru","Kolkata","Chennai"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        Calendar currentTime = Calendar.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        buttontime = findViewById(R.id.buttontime);
        textViewtime = findViewById(R.id.textView3);
        buttontime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog1();
            }
        });
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner1 = findViewById(R.id.spinner2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,places);
        spinner1.setAdapter(arrayAdapter);
        spinner.setAdapter(arrayAdapter);
        Button submitbutton = findViewById(R.id.submitbutton);
        Button clearbutton = findViewById(R.id.clearbutton);
        ToggleButton toggleButton =findViewById(R.id.toggleButton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = spinner.getSelectedItem().toString();
                String s2 = spinner1.getSelectedItem().toString();
                String s3 = toggleButton.getText().toString();
                String s4 = textView.getText().toString();
                String s5 = textViewtime.getText().toString();
                Calendar currentTime = Calendar.getInstance();


                if (toggleButton.isChecked() && currentTime.get(Calendar.HOUR_OF_DAY) < 11) {

                    Toast.makeText(MainActivity.this, "You can only book after 11:00 AM for tatkal", Toast.LENGTH_LONG).show();
                } else {

                    openactivity(s1, s2, s3, s4, s5);
                }
            }
        });
        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner1.setSelection(0);
                spinner.setSelection(0);
                textView.setText("");
                toggleButton.setChecked(false);
                textViewtime.setText("");

            }
        });

    }
    public void openactivity(String s1,String s2,String s3,String s4,String s5){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("from",s1);
        intent.putExtra("To",s2);
        intent.putExtra("way",s3);
        intent.putExtra("Date",s4);
        intent.putExtra("Time",s5);
        startActivity(intent);
    }
    public void openDialog()
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                textView.setText(String.valueOf(i)+"-"+String.valueOf(i1+1)+"-"+String.valueOf(i2));
            }
        }, 2023, 01, 20);
        datePickerDialog.show();
    }
    public void openDialog1()
    {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                textViewtime.setText(String.valueOf(i)+":"+String.valueOf(i1+1));
            }
        }, 00, 00, true);
        timePickerDialog.show();
    }
}