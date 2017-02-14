package es.ulpgc.eite.android.quiz.CheatScreen.presenter;

import es.ulpgc.eite.android.quiz.MainScreen.view.QuizView;
import es.ulpgc.eite.android.quiz.Mediator.QuizApp;

/**
 * Created by Pedro Arenas on 13/2/17.
 */

public class CheatPresenter {
    private String falseLabel, trueLabel;
    private String confirmLabel;
    private QuizApp quizApp;
    private boolean toolbarVisible;
    private boolean answerVisible;
    private boolean confirmBtnClicked;
    private boolean trueAnswer;


    public CheatPresenter(QuizApp quizApp) {
        this.quizApp = quizApp;
    }

    public void onScreenStarted() {
        falseLabel = "False";
        trueLabel = "True";
        confirmLabel = "Are you sure?";

        setButtonLabels();
        checkVisibility();

        if(confirmBtnClicked){
          setAnswer(Boolean.valueOf(getAnswer()));
        }
    }



    //Poner Nombres botones
    private void setButtonLabels(){
        quizApp.getCheatView().setTrueButton(getTrueLabel());
        quizApp.getCheatView().setFalseButton(getFalseLabel());
        quizApp.getCheatView().setConfirm(getConfirmLabel());
    }
    private String getTrueLabel() {
        return trueLabel;
    }
    private String getFalseLabel() {
        return falseLabel;
    }
    private String getConfirmLabel() {
        return confirmLabel;
    }

    //Revisar la visibilidad
    private void checkVisibility(){
        checkToolbarVisibility();
        checkAnswerVisibility();
    }

    private void checkAnswerVisibility() {
        if(!isAnswerVisible()) {
            quizApp.getCheatView().hideAnswer();
        } else {
            quizApp.getCheatView().showAnswer();
        }
    }
    private boolean isAnswerVisible() {
        return answerVisible;
    }

    private void checkToolbarVisibility() {
        if (!isToolbarVisible()) {
            quizApp.getCheatView().hideToolbar();
        }
    }
    private boolean isToolbarVisible() {
        return toolbarVisible;
    }



    private void setAnswer(Boolean answer){
         this.trueAnswer = answer;
    }
    private String getAnswer() {
        if(trueAnswer) {
            return trueLabel;
        } else {
            return falseLabel;
        }
    }



    //Botones presionados
    public void onTrueBtnClicked() {
        quizApp.getCheatView().setAnswer(getAnswer());
        setAnswerVisibility(true);
        confirmBtnClicked = true;
        checkAnswerVisibility();
    }
    private void setAnswerVisibility(boolean visible) {
        answerVisible = visible;
    }

    public void onFalseBtnClicked() {
        quizApp.getCheatView().OverActivity();
    }
}
