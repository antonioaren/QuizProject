package es.ulpgc.eite.android.quiz.model;

import es.ulpgc.eite.android.quiz.QuestionStore;

/**
 * Created by User on 05/02/2017.
 */

public class QuizModel {
    private QuestionStore questionstore;

    public QuizModel() {
        questionstore = new QuestionStore();
    }

    public void setUp() {


    }

    public void onAnswerBtnClicked(boolean b) {
    }

    public void setbuttonLabels() {
        questionstore.getTrueLabel();
        questionstore.getFalseLabel();
        questionstore.getCheatLabel();
        questionstore.getNextLabel();
    }
}
