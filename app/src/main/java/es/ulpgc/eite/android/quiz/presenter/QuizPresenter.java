package es.ulpgc.eite.android.quiz.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.CheatActivity;
import es.ulpgc.eite.android.quiz.QuestionActivity;
import es.ulpgc.eite.android.quiz.QuestionStore;


/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {

    private QuestionActivity view;
    private QuestionStore questionStore;


    public QuizPresenter(){
        view = new QuestionActivity();
        questionStore = new QuestionStore();
    }

    public void onScreenStarted() {
        this.setButtonLabels();
        this.checkVisibility();
        view.setQuestion(questionStore.getCurrentAnswer());

      if(view.isAnswerBtnClicked()){
         view.setAnswer(questionStore.getCurrentAnswer());
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
        view.setQuestion(questionStore.getNextQuestion());
    }


    private void setButtonLabels(){
        view.setTrueButton(questionStore.getTrueLabel());
        view.setFalseButton(questionStore.getFalseLabel());
        view.setCheatButton(questionStore.getNextLabel());
        view.setNextButton(questionStore.getNextLabel());
    }

    private void onAnswerBtnClicked (boolean answer){
        questionStore.setCurrentAnswer(answer);
        view.setAnswer(questionStore.getCurrentAnswer());
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
