package es.ulpgc.eite.android.quiz.presenter;

import android.support.v7.app.AppCompatActivity;
import es.ulpgc.eite.android.quiz.model.QuizModel;

/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {
    private QuizModel model;


    public QuizPresenter(){
        model = new QuizModel();

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

    public void onScreenStarted() {

    }
}
