package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/17/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity {

    private ProgressBar progressBar;
    private Button answerOne;
    private Button answerTwo;
    private TextView questionText;
    private MyersBriggsQuiz myers = new MyersBriggsQuiz(0);
    private double progressGlob;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressGlob = 0;
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        answerOne = (Button) findViewById(R.id.answerOne);
        answerTwo = (Button) findViewById(R.id.answerTwo);
        questionText = (TextView) findViewById(R.id.questionText);

        Bundle myBundle = getIntent().getExtras();
        int value = -1;
        if (myBundle != null) {
            value = myBundle.getInt("key");
        }

        if (value == 1) {
            setTitle(myers.getName());
            myersQuiz();
        }

    }


    protected void myersQuiz() {
        MyersBriggsQuiz.Question temp = myers.getQuestion();
        questionText.setText(temp.getText());
        answerOne.setText(temp.answers[0].getText());
        answerTwo.setText(temp.answers[1].getText());

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        double incSize = 100.0/(myers.questionList.size());
        progressGlob += incSize;

        System.out.print(progressGlob);
        System.out.print(" ");
        System.out.println(myers.questionList.size());

            answerOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myers.recordResponse(myers.getQuestion(), myers.getQuestion().answers[0]);
                    myers.nextQuestion();
                    if (myers.getQuestion() == myers.questionList.get(myers.questionList.size() - 1)) {
                        myers.getResult();
                        finish();
                    }
                    progressBar.setProgress((int)progressGlob);
                    myersQuiz();
                }
            });

            answerTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myers.recordResponse(myers.getQuestion(), myers.getQuestion().answers[1]);
                    myers.nextQuestion();
                    if (myers.getQuestion() == myers.questionList.get(myers.questionList.size() - 1)) {
                        myers.getResult();
                        finish();
                    }
                    progressBar.setProgress((int)progressGlob);
                    myersQuiz();
                }
            });

        }
}
