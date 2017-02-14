package es.ulpgc.eite.android.quiz.Mediator;

import android.app.Application;
import android.content.Intent;

import es.ulpgc.eite.android.quiz.CheatScreen.view.CheatActivity;
import es.ulpgc.eite.android.quiz.CheatScreen.presenter.CheatPresenter;
import es.ulpgc.eite.android.quiz.Store.QuestionStore;
import es.ulpgc.eite.android.quiz.MainScreen.presenter.QuizPresenter;
import es.ulpgc.eite.android.quiz.MainScreen.view.QuizView;

public class QuizApp extends Application {

  private QuestionState questionState;
  private CheatState cheatState;
  private QuestionStore questionStore;
  private QuizView MainView;
  private CheatActivity CheatView;
  private QuizPresenter QuizPresenter;
  private CheatPresenter CheatPresenter;

  @Override
  public void onCreate() {
    super.onCreate();

    questionState = new QuestionState();

    questionState.toolbarVisible = false;
    questionState.answerVisible = false;

  }

  //Models
  public QuestionStore getQuestionStore(){
    if ( questionStore == null) {
      questionStore = new QuestionStore(this);
    }
    return questionStore;
  }

  // Views
  public QuizView getMainView() {
    return MainView;
  }
  public CheatActivity getCheatView() {
    return CheatView;
  }

  //Presenters
  public QuizPresenter getQuizPresenter() {
    if (QuizPresenter == null){
      QuizPresenter = new QuizPresenter(this);
    }
    return QuizPresenter;
  }
  public CheatPresenter getCheatPresenter() {
    if (CheatPresenter == null){
      CheatPresenter = new CheatPresenter(this);
    }
    return CheatPresenter;
  }

  public void registerView(QuizView quizView) {
    this.MainView = quizView;
    //this.CheatView = quizView;
  }


  public boolean isAnswerBtnClicked() {
    return questionState.answerBtnClicked;
  }
  public void setAnswerBtnClicked(boolean clicked) {
    questionState.answerBtnClicked = clicked;
  }
  public boolean isAnswerVisible() {
    return questionState.answerVisible;
  }
  public boolean isToolbarVisible() {
    return questionState.toolbarVisible;
  }
  public void setAnswerVisibility(boolean visible) {
    questionState.answerVisible = visible;
  }

  public void goToCheatScreen(QuizView activity){
    cheatState = new CheatState();
    cheatState.toolbarVisible = false;
    cheatState.answerVisible = false;
    cheatState.answerBtnClicked = questionState.answerBtnClicked;

    activity.startActivity(new Intent(activity, CheatActivity.class));
  }
  public void backToQuestionScreen(CheatActivity activity){
    activity.finish();
  }


  //Estado de la pregunta
  private class QuestionState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;

  }
  private class CheatState {
    boolean toolbarVisible;
    boolean answerVisible;
    boolean answerBtnClicked;
  }
}
