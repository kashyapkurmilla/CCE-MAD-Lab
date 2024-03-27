package com.example.lab8ques4;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    EditText nameEditText, studentIdEditText, semesterEditText, branchEditText, facultyEditText;
    Button addButton;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameEditText = findViewById(R.id.nameEditText);
        studentIdEditText = findViewById(R.id.studentIdEditText);
        semesterEditText = findViewById(R.id.semesterEditText);
        branchEditText = findViewById(R.id.branchEditText);
        facultyEditText = findViewById(R.id.facultyEditText);
        addButton = findViewById(R.id.addButton);
        dbHelper = new DBHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String studentId = studentIdEditText.getText().toString();
                String semester = semesterEditText.getText().toString();
                String branch = branchEditText.getText().toString();
                String faculty = facultyEditText.getText().toString();

                if (name.isEmpty() || studentId.isEmpty() || semester.isEmpty() || branch.isEmpty() || faculty.isEmpty()) {
                    Toast.makeText(AddStudentActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted = dbHelper.insertStudent(name, studentId, semester, branch, faculty);
                    if (isInserted) {
                        Toast.makeText(AddStudentActivity.this, "Student added successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddStudentActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
