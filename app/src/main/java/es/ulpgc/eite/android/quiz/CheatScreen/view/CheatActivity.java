package es.ulpgc.eite.android.quiz.CheatScreen.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.android.quiz.Mediator.QuizApp;
import es.ulpgc.eite.android.quiz.R;

public class CheatActivity extends AppCompatActivity {


  private QuizApp quizApp;

  private Toolbar toolbarScreen;
  private Button buttonTrue, buttonFalse;
  private TextView labelConfirm, labelAnswer;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    quizApp = (QuizApp) getApplication();
    quizApp.registerCheatView(this);


    labelConfirm = (TextView) findViewById(R.id.labelConfirm);
    labelAnswer = (TextView) findViewById(R.id.labelAnswer);

    toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbarScreen);

    buttonTrue = (Button) findViewById(R.id.buttonTrue);
    buttonTrue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        quizApp.getCheatPresenter().onTrueBtnClicked();
      }
    });
    buttonFalse = (Button) findViewById(R.id.buttonFalse);
    buttonFalse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        quizApp.getCheatPresenter().onFalseBtnClicked();
      }
    });

    quizApp.getCheatPresenter().onScreenStarted();
  }

//  private void onScreenStarted() {
//
//    falseLabel = "False";
//    trueLabel = "True";
//    confirmLabel = "Are you sure?";
//
//    setButtonLabels();
//    checkVisibility();
//
//    if(confirmBtnClicked){
//      setAnswer(getAnswer());
//    }
//  }
  //private void setAnswerVisibility(boolean visible) {
  //  quizApp.setAnswerVisibility(visible);
  //}
  //
  //private boolean isAnswerVisible() {
  //  return quizApp.isAnswerVisible();
  //}
  //
  //private boolean isToolbarVisible() {
  //  return quizApp.isToolbarVisible();
  //}
  //private void checkVisibility(){
  //checkToolbarVisibility();
  //checkAnswerVisibility();
  //}
  //private void checkToolbarVisibility(){
  //if (!isToolbarVisible()) {
  //hideToolbar();
  //}
  //}
  //private boolean isToolbarVisible() {
  //  return toolbarVisible;
  //}
//  private void onFalseBtnClicked() {
//    finish();
//    //quizApp.backToQuestionScreen(this);
// }
//  private void onTrueBtnClicked() {
//    setAnswer(getAnswer());
//    setAnswerVisibility(true);
//    confirmBtnClicked = true;
//    //checkAnswerVisibility();
//  }
//
//
//  private void setAnswerVisibility(boolean visible) {
//    answerVisible = visible;
//  }
//
//
//
//  private boolean isAnswerVisible() {
//    return answerVisible;
//  }
//
//  //private void checkAnswerVisibility(){
//  //}
//  //setConfirm(getConfirmLabel());
//  //setFalseButton(getFalseLabel());
//  //setTrueButton(getTrueLabel());
//  //private void setButtonLabels(){
//  //}
//  //  }
//  //    showAnswer();
//  //  } else {
//  //  hideAnswer();
//  //if(!isAnswerVisible()) {
//private void setAnswer(boolean answer){
//  trueAnswer = answer;
//}
//
//  private String getAnswer() {
//    if(trueAnswer) {
//      return trueLabel;
//    } else {
//      return falseLabel;
//    }
//  }


  public void hideToolbar() {
    toolbarScreen.setVisibility(View.GONE);
  }

  public void setConfirm(String text) {
    labelConfirm.setText(text);
  }
  public void setFalseButton(String label) {
    buttonFalse.setText(label);
  }
  public void setTrueButton(String label) {
    buttonTrue.setText(label);
  }
  public void setAnswer(String txt) {
    labelAnswer.setText(txt);
  }

  public void hideAnswer() {
    labelAnswer.setVisibility(View.INVISIBLE);
  }
  public void showAnswer() {
    labelAnswer.setVisibility(View.VISIBLE);
  }

  public void OverActivity(){
    quizApp.backToQuestionScreen(this);
  }
}
