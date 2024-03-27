package com.example.lab8q4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewStudentsActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Student> studentList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        listView = findViewById(R.id.listView);
        studentList = new ArrayList<>();
        dbHelper = new DBHelper(this);

        loadStudentList();

        registerForContextMenu(listView);
    }

    private void loadStudentList() {
        studentList = dbHelper.getAllStudents();
        StudentAdapter adapter = new StudentAdapter(this, R.layout.student_item, studentList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
            if(item.getItemId() == R.id.menu_view) {
                viewStudentDetails(position);
                return true;
            }
            else if(item.getItemId() == R.id.menu_delete) {
                deleteStudent(position);
                return true;
            }
            return false;

    }

    private void viewStudentDetails(int position) {
        Student student = studentList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Student Details");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView nameTextView = new TextView(this);
        nameTextView.setText("Name: " + student.getName());
        layout.addView(nameTextView);

        TextView studentIdTextView = new TextView(this);
        studentIdTextView.setText("Student ID: " + student.getStudentId());
        layout.addView(studentIdTextView);

        TextView semesterTextView = new TextView(this);
        semesterTextView.setText("Semester: " + student.getSemester());
        layout.addView(semesterTextView);

        TextView branchTextView = new TextView(this);
        branchTextView.setText("Branch: " + student.getBranch());
        layout.addView(branchTextView);

        TextView facultyTextView = new TextView(this);
        facultyTextView.setText("Faculty Incharge: " + student.getFaculty());
        layout.addView(facultyTextView);

        builder.setView(layout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }


    private void deleteStudent(int position) {
        Student student = studentList.get(position);
        dbHelper.deleteStudent(student.getStudentId());
        loadStudentList();
        Toast.makeText(this, "Student deleted", Toast.LENGTH_SHORT).show();
    }
}

