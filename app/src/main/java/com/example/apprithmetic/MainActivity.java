package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    TextView equationText;
    EditText userInput;
    Button button;
    TextView displayResult;

    QuizLogic quizzer;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationText = findViewById(R.id.equationText);

        button = findViewById(R.id.button);

        userInput = findViewById(R.id.userInput);
        displayResult = findViewById(R.id.displayResult);
    }

    @Override
    protected void onStart() {
        super.onStart();

        quizzer = new QuizLogic();
        showNewEquation(quizzer);

//        Handler handler = new Handler(Looper.getMainLooper());

//        class NextQuestion extends Thread {
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                }
//                catch (InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                    ex.printStackTrace();
//                }
//
//                showNewEquation(quizzer);
//
//            }
//        }



        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                result = quizzer.answerIsCorrect(userInput.getText().toString());
                displayResult.setText(result);
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (result.equals("Correct") || result.equals("Incorrect")) {
//
//            displayResult.setText(result);
//
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            }
//            catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//                ex.printStackTrace();
//            }
//
//            nextEquation(quizzer);
////            userInput.getText().clear();
////            displayResult.setText("");
////            }
////
////
//    }

    public void showNewEquation(QuizLogic quizzer) {

        quizzer.generateEquation();

        TextView equationText = findViewById(R.id.equationText);
        equationText.setText(String.format("%s =", quizzer.getEquation()));
    }

}