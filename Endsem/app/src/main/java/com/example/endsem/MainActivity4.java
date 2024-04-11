package com.example.endsem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private EditText inputreg,name,regno,marks;
    private Button submit,edit;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        inputreg=findViewById(R.id.editText1);
        name=findViewById(R.id.editText2);
        regno=findViewById(R.id.editText3);
        marks=findViewById(R.id.editText4);

        edit=findViewById(R.id.editbtn);
        submit=findViewById(R.id.sbmt);

        db =new DBHelper(MainActivity4.this);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpreg = inputreg.getText().toString();
                showData(inpreg);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String r= regno.getText().toString();
                String m = marks.getText().toString();
                int m1=Integer.parseInt(m);

                db.Update(n,r,m1);

                Toast.makeText(MainActivity4.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

                name.setText("");
                regno.setText("");
                marks.setText("");
            }
        });
    }

    public void showData(String input){
        Cursor cursor=db.Showdata();
        while(cursor.moveToNext()){
            if(cursor.getString(2).equals(input)){
                name.setText(cursor.getString(1));
                regno.setText(cursor.getString(2));
                marks.setText(cursor.getString(3));
            }
        }

    }

}