package es.ulpgc.eite.android.quiz.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.CheatActivity;

import es.ulpgc.eite.android.quiz.model.QuizModel;
import es.ulpgc.eite.android.quiz.view.QuizView;


/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {

    private QuizView view;
    private QuizModel quizModel;


    public QuizPresenter(QuizView quizView){
        this.view = quizView;
        quizModel = new QuizModel();
    }

    public void onScreenStarted() {
        this.setButtonLabels();
        this.checkVisibility();
        view.setQuestion(quizModel.getCurrentAnswer());

      if(view.isAnswerBtnClicked()){
         view.setAnswer(quizModel.getCurrentAnswer());
      }

    }

    public void onTrueBtnClicked() {
        this.onAnswerBtnClicked(true);
    }
    public void onFalseBtnClicked() {
        this.onAnswerBtnClicked(false);
    }
    public void onCheatBtnClicked() {
        this.GoToCheatScreen();
    }
    public void onNextBtnClicked() {
        view.setQuestion(quizModel.getNextQuestion());
    }


    private void setButtonLabels(){
        view.setTrueButton(quizModel.getTrueLabel());
        view.setFalseButton(quizModel.getFalseLabel());
        view.setCheatButton(quizModel.getNextLabel());
        view.setNextButton(quizModel.getNextLabel());
    }

    private void onAnswerBtnClicked (boolean answer){
        quizModel.setCurrentAnswer(answer);
        view.setAnswer(quizModel.getCurrentAnswer());
        view.setAnswerVisibility(true);
        view.setAnswerBtnClicked(true);

        this.checkAnswerVisibility();
    }

    private void checkToolbarVisibility(){
        if (!view.isToolbarVisible()) {
            view.hideToolbar();
        }
    }

    private void checkVisibility(){
        checkToolbarVisibility();
        checkAnswerVisibility();
    }
    private void checkAnswerVisibility(){
        if(!view.isAnswerVisible()) {
            view.hideAnswer();
        } else {
            view.showAnswer();
        }
    }

    private void GoToCheatScreen(){
        startActivity(new Intent(this, CheatActivity.class));
    }




}
