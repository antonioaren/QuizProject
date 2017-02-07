package es.ulpgc.eite.android.quiz.model;

import es.ulpgc.eite.android.quiz.QuestionStore;

/**
 * Created by User on 05/02/2017.
 */

public class QuizModel {

    private boolean answerVisible;
    private boolean answerBtnClicked;


    public QuizModel() {
    }

    public void setAnswerVisibility(boolean visible) {
        answerVisible = visible;
    }

    public void setAnswerBtnClicked(boolean clicked) {
        answerBtnClicked = clicked;
    }

    public boolean isAnswerVisible() {
        return answerVisible;
    }




}
