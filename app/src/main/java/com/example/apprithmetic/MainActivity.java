package com.example.apprithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    TextView equationText;
    EditText userInput;
    Button button;
    TextView displayResult;
    TextView displayStreak;

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
        displayStreak = findViewById(R.id.displayStreak);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();

        quizzer = new QuizLogic();
        showNewEquation(quizzer);

        displayStreak.setText("Current Streak: 0");

        final Handler handler = new Handler(Looper.getMainLooper());

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                userInput.onEditorAction(EditorInfo.IME_ACTION_DONE);

                result = quizzer.answerIsCorrect(userInput.getText().toString());
                if (result.equals("Correct")) {
                    displayResult.setText(result.concat("!"));
                } else {
                    String solution = ": ".concat(Long.toString(quizzer.getSolution()));
                    displayResult.setText(result.concat(solution));
                }

                int currentStreak = quizzer.getStreak();
                displayStreak.setText("Current Streak: ".concat(String.valueOf(currentStreak)));

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        }
                        catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                            ex.printStackTrace();
                        }
                        showNewEquation(quizzer);
                        userInput.getText().clear();
                        displayResult.setText("");
                    }
                });
            }
        });
    }

    public void showNewEquation(QuizLogic quizzer) {

        quizzer.generateEquation();

        TextView equationText = findViewById(R.id.equationText);
        equationText.setText(String.format("%s =", quizzer.getEquation()));
        showKeyboard(userInput);
    }

    public void showKeyboard(View inputField) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(inputField, InputMethodManager.SHOW_IMPLICIT);
    }

}