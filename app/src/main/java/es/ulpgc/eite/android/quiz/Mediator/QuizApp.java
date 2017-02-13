package es.ulpgc.eite.android.quiz.Mediator;

import android.app.Application;
import android.content.Intent;

import es.ulpgc.eite.android.quiz.CheatActivity;
import es.ulpgc.eite.android.quiz.model.QuestionStore;
import es.ulpgc.eite.android.quiz.presenter.QuizPresenter;
import es.ulpgc.eite.android.quiz.view.QuizView;

public class QuizApp extends Application {

  private QuestionState questionState;
  private CheatState cheatState;

  private QuestionStore questionStore;
  private QuizView view;
  private QuizPresenter presenter;

  @Override
  public void onCreate() {
    super.onCreate();

    questionState = new QuestionState();

    questionState.toolbarVisible = false;
    questionState.answerVisible = false;

  }

  public QuestionStore getQuestionStore(){
    if ( questionStore == null) {
      questionStore = new QuestionStore();
    }
    return questionStore;
  }

  public QuizView getView() {
    return view;
  }

  public QuizPresenter getPresenter() {
    if (presenter == null){
      presenter = new QuizPresenter(this);
    }
    return presenter;
  }

  public void registerView(QuizView quizView) {
    this.view = quizView;
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