package com.example.q2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView
        textView = findViewById(R.id.textView2);

        // Set click listeners for number buttons
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("1");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("2");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("3");
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("4");
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("5");
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("6");
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("7");
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("8");
            }
        });

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("9");
            }
        });

        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("0");
            }
        });
        findViewById(R.id.buttonplus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("+");
            }
        });

        findViewById(R.id.buttonmod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("%");
            }
        });
        findViewById(R.id.buttonsub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("-");
            }
        });
        findViewById(R.id.buttonl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("(");
            }
        });
        findViewById(R.id.buttonr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText(")");
            }
        });
        findViewById(R.id.buttondot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText(".");
            }
        });
        findViewById(R.id.buttonmul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("*");
            }
        });

        findViewById(R.id.buttondiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendText("/");
            }
        });
        findViewById(R.id.buttonclr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearText();
            }
        });
        findViewById(R.id.buttonequ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView.getText().toString();
                String result = EvaluateExpression(str);
                textView.setText(result);
            }
        });


    }

    // Method to append text to TextView
    private void appendText(String text) {
        textView.append(text);
    }

    private void clearText() {
        textView.setText("");
    }

    private String EvaluateExpression(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scope = context.initStandardObjects();
            Object result = context.evaluateString(scope, data, "<cmd>", 1, null);
            String finalResult = Context.toString(result);
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            e.printStackTrace();
            return "Err";
        }
    }


}
