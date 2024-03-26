package com.example.p3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuIcon = findViewById(R.id.menuIcon);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSubMenu();
            }
        });
    }

    private void showSubMenu() {
        PopupMenu popupMenu = new PopupMenu(this, menuIcon);
        popupMenu.getMenuInflater().inflate(R.menu.submenu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.image1) {
                    displayToastWithImage(R.drawable.image1, "Image - 1");
                    return true;
                } else if (item.getItemId() == R.id.image2) {
                    displayToastWithImage(R.drawable.image2, "Image - 2");
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }


    private void displayToastWithImage(int imageResource, String message) {
        // Create a new toast
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);

        // Get the original toast view
        View originalToastView = toast.getView();

        // Inflate a new layout containing the ImageView and original view
        LayoutInflater inflater = getLayoutInflater();
        View toastLayout = inflater.inflate(R.layout.custom_toast, null);

        // Find the ImageView and set its image resource
        ImageView imageView = toastLayout.findViewById(R.id.toastImageView);
        imageView.setImageResource(imageResource);

        // Find the original view within the inflated layout
        TextView textView = toastLayout.findViewById(android.R.id.message);

        // Set the original text to the TextView
        textView.setText(message);

        // Set the modified layout as the view for the toast
        toast.setView(toastLayout);
        toast.show();
    }

}
