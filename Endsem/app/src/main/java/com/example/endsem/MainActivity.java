package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
//import android.support.*;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item1)
        {

            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i);
        }
        if(id==R.id.item2)
        {

            Intent i = new Intent(getApplicationContext(), MainActivity3.class);
            startActivity(i);
        }
        if(id==R.id.item3)
        {

            Intent i = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(i);
        }
        if(id==R.id.item4)
        {
            Toast.makeText(this, "Bye!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}