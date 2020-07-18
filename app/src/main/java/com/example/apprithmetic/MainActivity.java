package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView equationText = findViewById(R.id.equationText);

        Button button = findViewById(R.id.button);

        final EditText userInput = findViewById(R.id.userInput);
        final TextView displayResult = findViewById(R.id.displayResult);

        final QuizLogic quizzer = new QuizLogic();
        quizzer.generateEquation();
        equationText.setText(String.format("%s =", quizzer.getEquation()));

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                final int givenAnswer = Integer.parseInt(userInput.getText().toString());
                if (givenAnswer == quizzer.getSolution()) {
                    displayResult.setText("Correct!");
                } else {
                    displayResult.setText("Incorrect!");
                    nextEquation(quizzer);
                    userInput.getText().clear();
//                displayResult.setText("");
                }
            }
        });
    }

    public void nextEquation(QuizLogic quizzer) {
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            ex.printStackTrace();
        }

        quizzer.generateEquation();

        TextView equationText = findViewById(R.id.equationText);
        equationText.setText(String.format("%s =", quizzer.getEquation()));
    }

}