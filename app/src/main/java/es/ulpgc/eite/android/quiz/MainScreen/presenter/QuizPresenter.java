package es.ulpgc.eite.android.quiz.MainScreen.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import es.ulpgc.eite.android.quiz.CheatScreen.view.CheatActivity;
import es.ulpgc.eite.android.quiz.Mediator.QuizApp;


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

        mediator.getMainView().setQuestion(mediator.getQuestionStore().getCurrentQuestion());

        //Esto lo que hace es guardar la respuesta en caso de que se cambie la orientación de la pantalla-
        if(mediator.getMainView().isAnswerBtnClicked()){
            mediator.getMainView().setAnswer(mediator.getQuestionStore().getCurrentAnswer());
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
        mediator.getMainView().setQuestion(mediator.getQuestionStore().getNextQuestion());
    }


    private void setButtonLabels(){
        mediator.getMainView().setTrueButton(mediator.getQuestionStore().getTrueLabel());
        mediator.getMainView().setFalseButton(mediator.getQuestionStore().getFalseLabel());
        mediator.getMainView().setCheatButton(mediator.getQuestionStore().getCheatLabel());
        mediator.getMainView().setNextButton(mediator.getQuestionStore().getNextLabel());
    }
    private void onAnswerBtnClicked (boolean answer){
        mediator.getQuestionStore().setCurrentAnswer(answer);
        mediator.getMainView().setAnswer(mediator.getQuestionStore().getCurrentAnswer());
        mediator.getMainView().setAnswerVisibility(true);
        mediator.getMainView().setAnswerBtnClicked(true);

        this.checkAnswerVisibility();
    }
    private void checkToolbarVisibility(){
        if (!mediator.getMainView().isToolbarVisible()) {
            mediator.getMainView().hideToolbar();
        }
    }
    private void checkVisibility(){
        checkToolbarVisibility();
        checkAnswerVisibility();
    }
    private void checkAnswerVisibility(){
        if(!mediator.getMainView().isAnswerVisible()) {
            mediator.getMainView().hideAnswer();
        } else {
            mediator.getMainView().showAnswer();
        }
    }
    private void GoToCheatScreen(){
        startActivity(new Intent(this, CheatActivity.class));
    }




}
