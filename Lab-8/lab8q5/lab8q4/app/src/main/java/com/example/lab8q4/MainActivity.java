package com.example.lab8q4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etStudentId, etSemester, etBranch, etFaculty;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etStudentId = findViewById(R.id.et_student_id);
        etSemester = findViewById(R.id.et_semester);
        etBranch = findViewById(R.id.et_branch);
        etFaculty = findViewById(R.id.et_faculty);
        btnSave = findViewById(R.id.btn_save);
        DBHelper dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStudentDetails();
            }
        });
    }

    private void saveStudentDetails() {
        String name = etName.getText().toString();
        String studentId = etStudentId.getText().toString();
        String semester = etSemester.getText().toString();
        String branch = etBranch.getText().toString();
        String faculty = etFaculty.getText().toString();

        DBHelper dbHelper = new DBHelper(this);
        long result = dbHelper.insertStudent(name, studentId, semester, branch, faculty);

        if (result != -1) {
            Toast.makeText(this, "Student details saved", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etStudentId.setText("");
            etSemester.setText("");
            etBranch.setText("");
            etFaculty.setText("");
        } else {
            Toast.makeText(this, "Failed to save student details", Toast.LENGTH_SHORT).show();
        }
    }
}
