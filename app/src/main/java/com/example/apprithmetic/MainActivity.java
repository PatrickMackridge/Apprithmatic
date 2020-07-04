package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String equation = "10 + 10";
        final int solution = 20;
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format("%s =", equation));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.editText);
                TextView displayResult = findViewById(R.id.displayResult);
                int givenAnswer = Integer.parseInt(editText.getText().toString());
                if (givenAnswer == solution) {
                    displayResult.setText("Correct!");
                } else {
                    displayResult.setText("Incorrect!");
                }

            }
        });
    }

}