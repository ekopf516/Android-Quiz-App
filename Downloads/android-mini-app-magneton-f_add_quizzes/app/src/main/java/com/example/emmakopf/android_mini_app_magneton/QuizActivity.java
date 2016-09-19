package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/17/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity {

    private ProgressBar progressBar;
    private Button answerOne;
    private Button answerTwo;
    private TextView questionText;
    private int progressStatus = 0;
    private MyersBriggsQuiz myers = new MyersBriggsQuiz();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        answerOne = (Button) findViewById(R.id.answerOne);
        answerTwo = (Button) findViewById(R.id.answerTwo);
        questionText = (TextView)findViewById(R.id.questionText);

    }


}
