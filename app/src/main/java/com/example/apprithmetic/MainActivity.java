package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String equation = "10 + 10";
        TextView textView = findViewById(R.id.textView);
        textView.setText(equation + " =");
    }

}