package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {

    private EditText nametxt,regnotxt,markstxt;
    private Button submitbtn;
    private DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nametxt = findViewById(R.id.name);
        regnotxt = findViewById(R.id.regno);
        markstxt = findViewById(R.id.marks);
        submitbtn = findViewById(R.id.submitbtn);

        dbhelper = new DBHelper(MainActivity2.this);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nametxt.getText().toString();
                String regno = regnotxt.getText().toString();
                String Marks = markstxt.getText().toString();

                if(name.isEmpty() || regno.isEmpty() || Marks.isEmpty() ){
                    Toast.makeText(MainActivity2.this,"Please enter all the data",Toast.LENGTH_SHORT).show();
                    return;
                }

                int marks =  Integer.parseInt(Marks);
                dbhelper.addNewStudent(name,regno,marks);
                Toast.makeText(MainActivity2.this,"Student Details has been added",Toast.LENGTH_SHORT).show();
                nametxt.setText("");
                regnotxt.setText("");
                markstxt.setText("");
            }
        });
    }
}