package com.example.lab8ques4;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_SEMESTER = "semester";
    private static final String COLUMN_BRANCH = "branch";
    private static final String COLUMN_FACULTY = "faculty";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_STUDENT_ID + " TEXT,"
                + COLUMN_SEMESTER + " TEXT,"
                + COLUMN_BRANCH + " TEXT,"
                + COLUMN_FACULTY + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStudent(String name, String studentId, String semester, String branch, String faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_STUDENT_ID, studentId);
        values.put(COLUMN_SEMESTER, semester);
        values.put(COLUMN_BRANCH, branch);
        values.put(COLUMN_FACULTY, faculty);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public ArrayList<String> getAllStudents() {
        ArrayList<String> studentList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                String studentId = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                studentList.add(studentId + " - " + name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return studentList;
    }

    public String[] getStudentById(String studentId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_NAME, COLUMN_STUDENT_ID, COLUMN_SEMESTER, COLUMN_BRANCH, COLUMN_FACULTY},
                COLUMN_STUDENT_ID + "=?", new String[]{studentId}, null, null, null, null);
        String[] studentDetails = null;
        if (cursor != null && cursor.moveToFirst()) {
            studentDetails = new String[]{
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_SEMESTER)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_BRANCH)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_FACULTY))
            };
            cursor.close();
        }
        return studentDetails;
    }

    public boolean updateStudent(String studentId, String name, String semester, String branch, String faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SEMESTER, semester);
        values.put(COLUMN_BRANCH, branch);
        values.put(COLUMN_FACULTY, faculty);
        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_STUDENT_ID + "=?", new String[]{studentId});
        return rowsAffected > 0;
    }

    public boolean deleteStudent(String studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_NAME, COLUMN_STUDENT_ID + "=?", new String[]{studentId});
        return rowsDeleted > 0;
    }
}

