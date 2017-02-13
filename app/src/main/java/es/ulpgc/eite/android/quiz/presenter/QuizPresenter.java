package es.ulpgc.eite.android.quiz.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.CheatActivity;

import es.ulpgc.eite.android.quiz.Mediator.QuizApp;
import es.ulpgc.eite.android.quiz.Mediator.QuizMediator;
import es.ulpgc.eite.android.quiz.model.QuestionStore;
import es.ulpgc.eite.android.quiz.view.QuizView;


/**
 * Created by Pedro Arenas on 05/02/2017.
 */

public class QuizPresenter extends AppCompatActivity {

    //private QuizView view;
    //private QuestionStore questionStore;
    private QuizApp mediator;


    public QuizPresenter(QuizApp quizApp) {
        this.mediator =  quizApp;
    }

    public void onScreenStarted() {
        this.setButtonLabels();
        this.checkVisibility();

        mediator.getView().setQuestion(mediator.getQuestionStore().getCurrentQuestion());

        //Esto lo que hace es guardar la respuesta en caso de que se cambie la orientación de la pantalla-
        if(mediator.getView().isAnswerBtnClicked()){
            mediator.getView().setAnswer(mediator.getQuestionStore().getCurrentAnswer());
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
        mediator.getView().setQuestion(mediator.getQuestionStore().getNextQuestion());
    }


    private void setButtonLabels(){
        mediator.getView().setTrueButton(mediator.getQuestionStore().getTrueLabel());
        mediator.getView().setFalseButton(mediator.getQuestionStore().getFalseLabel());
        mediator.getView().setCheatButton(mediator.getQuestionStore().getCheatLabel());
        mediator.getView().setNextButton(mediator.getQuestionStore().getNextLabel());
    }
    private void onAnswerBtnClicked (boolean answer){
        mediator.getQuestionStore().setCurrentAnswer(answer);
        mediator.getView().setAnswer(mediator.getQuestionStore().getCurrentAnswer());
        mediator.getView().setAnswerVisibility(true);
        mediator.getView().setAnswerBtnClicked(true);

        this.checkAnswerVisibility();
    }
    private void checkToolbarVisibility(){
        if (!mediator.getView().isToolbarVisible()) {
            mediator.getView().hideToolbar();
        }
    }
    private void checkVisibility(){
        checkToolbarVisibility();
        checkAnswerVisibility();
    }
    private void checkAnswerVisibility(){
        if(!mediator.getView().isAnswerVisible()) {
            mediator.getView().hideAnswer();
        } else {
            mediator.getView().showAnswer();
        }
    }
    private void GoToCheatScreen(){
        startActivity(new Intent(this, CheatActivity.class));
    }




}
