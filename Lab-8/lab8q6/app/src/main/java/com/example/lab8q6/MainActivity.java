package com.example.lab8q6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        // Restore the saved values
        editText1.setText(sharedPreferences.getString("editText1", ""));
        editText2.setText(sharedPreferences.getString("editText2", ""));
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save the current values when the app is paused
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("editText1", editText1.getText().toString());
        editor.putString("editText2", editText2.getText().toString());
        editor.apply();
    }
}
