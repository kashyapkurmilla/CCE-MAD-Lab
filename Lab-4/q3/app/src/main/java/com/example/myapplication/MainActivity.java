package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String versionName = button.getText().toString();
        int versionIconResId = getIconResource(button.getTag().toString());
        showToast(versionName, versionIconResId);
    }

    private int getIconResource(String versionTag) {
        switch (versionTag) {
            case "ice-cream":
                return R.drawable.icecreamsandwich;
            case "JellyBean":
                return R.drawable.jellybeans;
            case "Kitkat":
                return R.drawable.kitkat;
            case "lollipop":
                return R.drawable.lollipoop;


            // Add cases for other Android versions
            default:
                return 0;
        }
    }
    private void showToast(String versionName, int versionIconResId) {
        // Create custom toast layout
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                findViewById(R.id.custom_toast_container));

        // Set version name
        TextView text = layout.findViewById(R.id.text);
        text.setText(versionName);

        // Set version icon
        ImageView imageView = layout.findViewById(R.id.imageView);
        imageView.setImageResource(versionIconResId);

        // Display the toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}