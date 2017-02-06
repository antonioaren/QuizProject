package es.ulpgc.eite.android.quiz.presenter;

import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.QuestionActivity;
import es.ulpgc.eite.android.quiz.QuestionStore;
import es.ulpgc.eite.android.quiz.model.QuizModel;
import es.ulpgc.eite.android.quiz.view.QuizView;

/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {
    private QuizModel model;
    private QuestionActivity view;
    private QuestionStore questionStore;


    public QuizPresenter(){
        model = new QuizModel();
        view = new QuestionActivity();
        questionStore = new QuestionStore();

    }

    public void onScreenStarted() {
        this.setButtonLabels();
        view.checkVisibility();
        view.setQuestion(questionStore.getCurrentAnswer());


    }

    public void onTrueBtnClicked() {
        model.onAnswerBtnClicked(true);
    }

    public void onFalseBtnClicked() {
    }

    public void onCheatBtnClicked() {
    }

    public void onNextBtnClicked() {
    }

    private void setButtonLabels(){
        view.setTrueButton(questionStore.getTrueLabel());
        view.setFalseButton(questionStore.getFalseLabel());
        view.setCheatButton(questionStore.getNextLabel());
        view.setNextButton(questionStore.getNextLabel());
    }
}
