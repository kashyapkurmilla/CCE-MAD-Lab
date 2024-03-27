package com.example.lab8q2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "grocery.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "grocery";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_COST = "cost";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_COST + " REAL)";
        db.execSQL(query);
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_COST + ") VALUES ('Apples', 2.99)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_COST + ") VALUES ('Bananas', 1.99)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME + ", " + COLUMN_COST + ") VALUES ('Oranges', 3.49)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
