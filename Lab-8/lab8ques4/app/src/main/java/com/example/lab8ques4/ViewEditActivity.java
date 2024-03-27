package com.example.lab8ques4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ViewEditActivity extends AppCompatActivity {

    EditText nameEditText, studentIdEditText, semesterEditText, branchEditText, facultyEditText;
    DBHelper dbHelper;
    String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edit);

        nameEditText = findViewById(R.id.nameEditText);
        studentIdEditText = findViewById(R.id.studentIdEditText);
        semesterEditText = findViewById(R.id.semesterEditText);
        branchEditText = findViewById(R.id.branchEditText);
        facultyEditText = findViewById(R.id.facultyEditText);
        dbHelper = new DBHelper(this);

        studentId = getIntent().getStringExtra("STUDENT_ID");
        if (studentId != null) {
            String[] studentDetails = dbHelper.getStudentById(studentId);
            if (studentDetails != null) {
                nameEditText.setText(studentDetails[0]);
                studentIdEditText.setText(studentDetails[1]);
                semesterEditText.setText(studentDetails[2]);
                branchEditText.setText(studentDetails[3]);
                facultyEditText.setText(studentDetails[4]);
            } else {
                Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Student ID not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit_student) {
            String name = nameEditText.getText().toString();
            String semester = semesterEditText.getText().toString();
            String branch = branchEditText.getText().toString();
            String faculty = facultyEditText.getText().toString();

            boolean isUpdated = dbHelper.updateStudent(studentId, name, semester, branch, faculty);
            if (isUpdated) {
                Toast.makeText(this, "Student updated successfully", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Failed to update student", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

