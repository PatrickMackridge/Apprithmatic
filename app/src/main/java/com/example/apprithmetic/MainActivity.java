package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

        final QuizLogic quizzer = new QuizLogic();
        quizzer.generateEquation();
        TextView equationText = findViewById(R.id.equationText);
        equationText.setText(String.format("%s =", quizzer.getEquation()));

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                TextView displayResult = findViewById(R.id.displayResult);
                int givenAnswer = Integer.parseInt(editText.getText().toString());
                if (givenAnswer == quizzer.getSolution()) {
                    displayResult.setText("Correct!");
                } else {
                    displayResult.setText("Incorrect!");
                }
            }
        });
    }

}