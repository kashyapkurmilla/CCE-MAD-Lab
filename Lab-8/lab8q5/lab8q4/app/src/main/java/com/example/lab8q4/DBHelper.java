package com.example.lab8q4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDetails.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STUDENT = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_SEMESTER = "semester";
    private static final String COLUMN_BRANCH = "branch";
    private static final String COLUMN_FACULTY = "faculty";

    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_STUDENT_ID + " TEXT," +
            COLUMN_SEMESTER + " TEXT," +
            COLUMN_BRANCH + " TEXT," +
            COLUMN_FACULTY + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("DBHelper", "Context: " + context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
        try {
            db.execSQL(CREATE_TABLE_STUDENT);
            Log.d("DBHelper", "Table created successfully");
        } catch (SQLException e) {
            Log.e("DBHelper", "Error creating table: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    public long insertStudent(String name, String studentId, String semester, String branch, String faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_STUDENT_ID, studentId);
        values.put(COLUMN_SEMESTER, semester);
        values.put(COLUMN_BRANCH, branch);
        values.put(COLUMN_FACULTY, faculty);
        long result = db.insert(TABLE_STUDENT, null, values);
        db.close();
        return result;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                student.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                student.setStudentId(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID)));
                student.setSemester(cursor.getString(cursor.getColumnIndex(COLUMN_SEMESTER)));
                student.setBranch(cursor.getString(cursor.getColumnIndex(COLUMN_BRANCH)));
                student.setFaculty(cursor.getString(cursor.getColumnIndex(COLUMN_FACULTY)));
                studentList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;
    }
    public void updateStudent(int id, String name, String studentId, String semester, String branch, String faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_STUDENT_ID, studentId);
        values.put(COLUMN_SEMESTER, semester);
        values.put(COLUMN_BRANCH, branch);
        values.put(COLUMN_FACULTY, faculty);
        db.update(TABLE_STUDENT, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }


    public void deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, COLUMN_STUDENT_ID + " = ?", new String[]{studentId});
        db.close();
    }
}

