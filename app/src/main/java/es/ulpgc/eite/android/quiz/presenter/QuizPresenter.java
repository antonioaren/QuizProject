package es.ulpgc.eite.android.quiz.presenter;

import android.support.v7.app.AppCompatActivity;
import es.ulpgc.eite.android.quiz.model.QuizModel;
import es.ulpgc.eite.android.quiz.view.QuizView;

/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {
    private QuizModel model;


    public QuizPresenter(){
        model = new QuizModel();
        QuizView view = new QuizView();

    }

    public void onScreenStarted() {
        model.setbuttonLabels();

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
}
