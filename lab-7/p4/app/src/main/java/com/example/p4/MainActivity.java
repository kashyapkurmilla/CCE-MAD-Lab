package com.example.p4;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contentTextView = findViewById(R.id.contentTextView);
        Button filterButton = findViewById(R.id.filterButton);

        // Set the content about demonetization
        contentTextView.setText(getString(R.string.demonetization_description));

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterMenu(v);
            }
        });
    }


    private void showFilterMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.filter_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.keyword1) {
                    // Perform filtering based on keyword 1
                    return true;
                } else if (item.getItemId() == R.id.keyword2) {
                    // Perform filtering based on keyword 2
                    return true;
                } else if (item.getItemId() == R.id.sortOption) {
                    // Perform sorting
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }

}
