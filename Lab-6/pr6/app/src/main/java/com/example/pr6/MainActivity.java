package com.example.pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Set the toolbar as the app bar
    }

    @Override
    public boolean onCreateOptionsMenu(Menu    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file, menu); // Inflate the menu
        return true;
    }menu) {
        getMenuInflater().inflate(R.menu.menu_file, menu); // Inflate the menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_courses) {
            Intent intent = new Intent(MainActivity.this,Courses.class);
            startActivity(intent);
            showToast("Courses details displayed");
            return true;
        } else if (id == R.id.menu_admission) {
            // Handle Admission item click
            // Show admission details
            showToast("Admission details displayed");
            return true;
        } else if (id == R.id.menu_faculty) {
            // Handle Faculty item click
            // Show faculty details
            showToast("Faculty details displayed");
            return true;
        } else if (id == R.id.menu_contact_us) {
            Intent intent = new Intent(MainActivity.this,ContactUs.class);
            startActivity(intent);
            showToast("Contact Us details displayed");
            return true;
        } else if (id == R.id.menu_about_us) {
            // Handle About Us item click
            // Show about information
            showToast("About Us details displayed");
            return true;
        } else if (id == R.id.menu_homepage) {
            // Handle Homepage item click
            // Show homepage
            showToast("Homepage displayed");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, "Selected Item: " + message, Toast.LENGTH_SHORT).show();
    }
}
