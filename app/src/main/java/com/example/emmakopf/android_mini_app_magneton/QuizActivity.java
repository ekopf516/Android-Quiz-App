package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/17/16.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity {

    final Context context = this;
    private ProgressBar progressBar;
    private Button answerOne;
    private Button answerTwo;
    private TextView questionText;
    private MyersBriggsQuiz myers = new MyersBriggsQuiz(0);
    private double progressGlob;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        myers.resetResults();

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

        // AlertDialog to notify Quiz Results
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Quiz Results");

        // set dialog message
        alertDialogBuilder
                .setMessage("Your personality type is " + myers.getResult() + ". Click 'Yes' to exit and return to quizzes, click 'No' to return to the last question")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();

            answerOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myers.recordResponse(myers.getQuestion(), myers.getQuestion().answers[0]);


                    if (myers.getQuestion() == myers.questionList.get(myers.questionList.size() - 1)) {
                        System.out.println("reached end 1");
                        System.out.println(myers.getResult());

                        alertDialog.show();
                    }
                    else {
                        myers.nextQuestion();
                        progressBar.setProgress((int) progressGlob);
                        myersQuiz();
                    }
                }
            });

            answerTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myers.recordResponse(myers.getQuestion(), myers.getQuestion().answers[1]);
                    if (myers.getQuestion() == myers.questionList.get(myers.questionList.size() - 1)) {
                        System.out.println("reached end 2");
                        System.out.println(myers.getResult());

                        alertDialog.show();
                    }
                    else {
                        myers.nextQuestion();
                        progressBar.setProgress((int) progressGlob);
                        myersQuiz();
                    }
                }
            });

        }
}
