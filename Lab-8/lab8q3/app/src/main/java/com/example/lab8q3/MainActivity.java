package com.example.lab8q3;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> movieNames;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
        movieNames = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movieNames);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        tableLayout = findViewById(R.id.tableLayout);

        updateMovieList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayMovieDetails(position);
            }
        });
    }

    public void addReview(View view) {
        // Show dialog to add a movie review
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Movie Review");

        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_review, null);
        builder.setView(dialogView);

        EditText etMovieName = dialogView.findViewById(R.id.etMovieName);
        EditText etYear = dialogView.findViewById(R.id.etYear);
        EditText etRating = dialogView.findViewById(R.id.etRating);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String movieName = etMovieName.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int rating = Integer.parseInt(etRating.getText().toString());

                boolean result = dbHelper.addReview(movieName, year, rating);
                if (result) {
                    Toast.makeText(MainActivity.this, "Review added successfully", Toast.LENGTH_SHORT).show();
                    updateMovieList();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add review", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    private void updateMovieList() {
        // Update the movie list
        Cursor cursor = dbHelper.getReviews();
        movieNames.clear();
        if (cursor.moveToFirst()) {
            do {
                String movieName = cursor.getString(cursor.getColumnIndex("movie_name"));
                movieNames.add(movieName);
            } while (cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }

    private void displayMovieDetails(int position) {
        // Display the details of the selected movie
        tableLayout.removeAllViews();

        String movieName = movieNames.get(position);
        Cursor cursor = dbHelper.getReviews();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("movie_name"));
                if (name.equals(movieName)) {
                    int year = cursor.getInt(cursor.getColumnIndex("year"));
                    int rating = cursor.getInt(cursor.getColumnIndex("rating"));

                    TableRow row = new TableRow(this);
                    TextView textName = new TextView(this);
                    textName.setText(movieName);
                    row.addView(textName);

                    TextView textYear = new TextView(this);
                    textYear.setText(String.valueOf(year));
                    row.addView(textYear);

                    TextView textRating = new TextView(this);
                    textRating.setText(String.valueOf(rating));
                    row.addView(textRating);

                    tableLayout.addView(row);
                }
            } while (cursor.moveToNext());
        }
    }
}
