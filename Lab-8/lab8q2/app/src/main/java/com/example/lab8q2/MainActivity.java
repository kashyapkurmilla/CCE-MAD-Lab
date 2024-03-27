package com.example.lab8q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner grocerySpinner;
    private Button addButton;
    private TextView totalTextView;

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    private List<String> groceryItems;
    private ArrayAdapter<String> adapter;

    private double totalCost = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grocerySpinner = findViewById(R.id.grocerySpinner);
        addButton = findViewById(R.id.addButton);
        totalTextView = findViewById(R.id.totalTextView);

        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        groceryItems = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groceryItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grocerySpinner.setAdapter(adapter);

        loadGroceryItems();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedItem();
            }
        });

        grocerySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void loadGroceryItems() {
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);
        groceryItems.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            double cost = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COLUMN_COST));
            groceryItems.add(name + " - $" + cost);
        }
        adapter.notifyDataSetChanged();
        cursor.close();
    }

    private void addSelectedItem() {
        String selectedItem = grocerySpinner.getSelectedItem().toString();
        String[] parts = selectedItem.split(" - ");
        double cost = Double.parseDouble(parts[1].substring(1)); // Remove the $ sign
        totalCost += cost;
        totalTextView.setText("Total Cost: $" + totalCost);
    }
}
