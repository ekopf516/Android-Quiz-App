package com.example.emmakopf.android_mini_app_magneton;

/**
 * Created by EmmaKopf on 9/18/16.
 */
import java.util.List;

public interface Quiz
{
    String getName();
    String getResult();
    void recordResponse(QuizQuestion q, QuizEntity a);
    void resetResults();
    List<QuizQuestion> getQuestions();
}