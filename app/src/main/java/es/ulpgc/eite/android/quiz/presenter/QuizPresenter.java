package es.ulpgc.eite.android.quiz.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.CheatActivity;

import es.ulpgc.eite.android.quiz.model.QuestionStore;
import es.ulpgc.eite.android.quiz.view.QuizView;


/**
 * Created by User on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {

    private QuizView view;
    private QuestionStore questionStore;


    public QuizPresenter(QuizView quizView){
        this.view = quizView;
        questionStore = new QuestionStore();
    }

    public void onScreenStarted() {
        this.setButtonLabels();
        this.checkVisibility();
        view.setQuestion(questionStore.getCurrentQuestion());

        //Esto lo que hace es guardar la respuesta en caso de que se cambie la orientación de la pantalla-
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
        view.setCheatButton(questionStore.getCheatLabel());
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
