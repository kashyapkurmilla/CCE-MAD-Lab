package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;


import java.util.List;


public class MainActivity5 extends AppCompatActivity {
    private Spinner spinner;

    private Button selectbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        spinner = findViewById(R.id.spinner);
        selectbtn = findViewById(R.id.selectbtn);
        DBHelper db = new DBHelper(getApplicationContext());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                String label = parent.getItemAtPosition(position).toString();

                StringBuffer buffer = new StringBuffer();

                Cursor maincursor = db.Showdata();
                while(maincursor.moveToNext()) {
                    if (maincursor.getString(2) .equals(label)) {
                        buffer.append("Id : " + maincursor.getString(0) + "\n").append("Name : " + maincursor.getString(1) + "\n").append("Regno : " + maincursor.getString(2) + "\n")
                                .append("Marks : " + maincursor.getInt(3) + "\n");
                    }
                    message("Data",buffer.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        loadSpinnerData();



    }


    public void message(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title)
                .setMessage(message)
                .show();
    }


    private void loadSpinnerData(){
        DBHelper db = new DBHelper(getApplicationContext());
        List<String> labels = db.getallLabels();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }
}
