package com.example.lab8q5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "modified_database.db";
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Copy the modified database
        if (copyDatabase()) {
            // Use the modified database in your app
            SQLiteDatabase database = SQLiteDatabase.openDatabase(
                    getDatabasePath(DATABASE_NAME).getPath(),
                    null,
                    SQLiteDatabase.OPEN_READWRITE
            );

            // Query the database and display the modified data
            Cursor cursor = database.rawQuery("SELECT * FROM your_table", null);

            // Map cursor columns to TextViews in the layout
            String[] fromColumns = {"column1", "column2", "column3"}; // Replace with your column names
            int[] toViews = {R.id.textView1, R.id.textView2, R.id.textView3}; // Replace with your TextView IDs

            // Create a SimpleCursorAdapter
            adapter = new SimpleCursorAdapter(this,
                    R.layout.list_item_layout, // Replace with your custom layout for list items
                    cursor,
                    fromColumns,
                    toViews,
                    0);

            ListView listViewData = findViewById(R.id.listViewData);
            listViewData.setAdapter(adapter);

            // Close cursor and database
            cursor.close();
            database.close();
        } else {
            // Database copy failed, display an error message
            Toast.makeText(this, "Failed to copy database", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to copy the database
    private boolean copyDatabase() {
        try {
            // Path to the existing database in the assets directory
            String databasePath = "databases/" + DATABASE_NAME;
            // Path to the application's database directory
            String destinationPath = getDatabasePath(DATABASE_NAME).getPath();

            // Open the input stream from the assets database file
            InputStream inputStream = getAssets().open(databasePath);
            // Open the output stream to the application's database directory
            OutputStream outputStream = new FileOutputStream(destinationPath);

            // Copy the database file
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Close the streams
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            return true; // Database copy successful
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Database copy failed
        }
    }
}
