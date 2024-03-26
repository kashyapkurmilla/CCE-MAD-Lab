package com.example.l7;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String dataset[][] = {
            {"Aarav", "9123456780"},
            {"Abhiram", "9876543210"},
            {"Advait", "7345678902"},
            {"Navaneeth", "6456789013"},
            {"Amit", "5678901234"},
            {"Ananya", "9789012345"},
            {"sahith", "7890123456"},
            {"Avani", "8901234567"},
            {"Bhavya", "8901234568"},
            {"Nitits", "8012345679"},
            {"Deepika", "9876543210"},
            {"Dev", "8765432109"},
            {"Dia", "7654321098"},
            {"Divya", "7654321097"},
            {"Gaurav", "7543210986"},
            {"Gayatri", "7432109875"},
            {"Hari", "7321098764"},
            {"Isha", "7210987653"},
            {"Jai", "7109876542"},
            {"Kavya", "7098765431"}
    };
    ArrayAdapter<String[]> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2, android.R.id.text1, dataset) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                String[] item = dataset[position];
                text1.setText(item[0]);
                text2.setText(item[1]);
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);

        // Register ListView for context menu
        registerForContextMenu(listView);

        // Set item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Display popup menu
                showPopupMenu(view);
            }
        });
    }
    // Method to show popup menu
    private void showPopupMenu(View view) {
        // Create PopupMenu
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

        // Set item click listener for the popup menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                String itemName = item.getTitle().toString();
                if (itemId == R.id.makeCall) {
                    // Implement action for "Call" menu item
                    Toast.makeText(MainActivity.this, "Calling ", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.sendMessage) {
                    // Implement action for "Message" menu item
                    Toast.makeText(MainActivity.this, "Send a message", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.gmailAddress) {
                    // Implement action for "Gmail" menu item
                    Toast.makeText(MainActivity.this, "Send an email", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });

        // Show the popup menu
        popupMenu.show();
    }
}
