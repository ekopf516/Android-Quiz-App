package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/18/16.
 */
public class Question {
    public String question;
    public String answerOne;
    public String answerTwo;
    public int resultOne;
    public int resultTwo;

    public Question(String question, String answerOne, String answerTwo, int resultOne, int resultTwo) {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.resultOne = resultOne;
        this.resultTwo = resultTwo;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswerOne() {
        return this.answerOne;
    }

    public String getAnswerTwo() {
        return this.answerTwo;
    }

    public int getResultOne() {
        return this.resultOne;
    }

    public int getResultTwo() {
        return this.resultTwo;
    }
}
