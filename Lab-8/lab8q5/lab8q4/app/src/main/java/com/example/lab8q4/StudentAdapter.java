package com.example.lab8q4;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private int resource;
    private ArrayList<Student> studentList;

    public StudentAdapter(Context context, int resource, ArrayList<Student> studentList) {
        super(context, resource, studentList);
        this.context = context;
        this.resource = resource;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItem = inflater.inflate(resource, parent, false);
        }

        Student student = studentList.get(position);

        TextView nameTextView = listItem.findViewById(R.id.tv_name);
        nameTextView.setText(student.getName());

        TextView studentIdTextView = listItem.findViewById(R.id.tv_student_id);
        studentIdTextView.setText("ID: " + student.getStudentId());

        return listItem;
    }
}

