package es.ulpgc.eite.android.quiz.MainScreen.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.android.quiz.Mediator.QuizApp;
import es.ulpgc.eite.android.quiz.R;

public class QuizView extends AppCompatActivity {

  private boolean toolbarVisible;
  private boolean answerVisible;
  private boolean answerBtnClicked;

  private Toolbar toolbarScreen;
  private Button buttonTrue, buttonFalse, buttonCheat, buttonNext;
  private TextView labelQuestion, labelAnswer;


  private QuizApp mediator;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    mediator = (QuizApp) getApplication();
    mediator.registerQuizView(this);


    //presenter = new QuizPresenter(this);

    labelQuestion = (TextView) findViewById(R.id.labelQuestion);
    labelAnswer = (TextView) findViewById(R.id.labelAnswer);

    toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbarScreen);

    buttonTrue = (Button) findViewById(R.id.buttonTrue);
    buttonTrue.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediator.getQuizPresenter().onTrueBtnClicked();
      }
    });

    buttonFalse = (Button) findViewById(R.id.buttonFalse);
    buttonFalse.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediator.getQuizPresenter().onFalseBtnClicked();
      }
    });

    buttonCheat = (Button) findViewById(R.id.buttonCheat);
    buttonCheat.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediator.getQuizPresenter().onCheatBtnClicked();
      }
    });

    buttonNext = (Button) findViewById(R.id.buttonNext);
    buttonNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediator.getQuizPresenter().onNextBtnClicked();
      }
    });

    mediator.getQuizPresenter().onScreenStarted();
  }

//  private void onScreenStarted() {
//    //quizApp = (QuizApp) getApplication();
//    questionStore = new QuestionStore();
//
//    setButtonLabels();
//    checkVisibility();
//
//    setQuestion(getQuestionStore().getCurrentQuestion());
//
//    if(isAnswerBtnClicked()){
//      setAnswer(getQuestionStore().getCurrentAnswer());
//    }
//  }
//
//  private void setButtonLabels(){
//    setTrueButton(getQuestionStore().getTrueLabel());
//    setFalseButton(getQuestionStore().getFalseLabel());
//    setCheatButton(getQuestionStore().getCheatLabel());
//    setNextButton(getQuestionStore().getNextLabel());
//  }
//
//  private void onAnswerBtnClicked(boolean answer) {
//    getQuestionStore().setCurrentAnswer(answer);
//    setAnswer(getQuestionStore().getCurrentAnswer());
//    setAnswerVisibility(true);
//    setAnswerBtnClicked(true);
//
//    checkAnswerVisibility();
//  }
//
//  private void onTrueBtnClicked() {
////    onAnswerBtnClicked(true);
//  }
//
//  private void onFalseBtnClicked() {
////    onAnswerBtnClicked(false);
//  }
//
//  private void onCheatBtnClicked() {
//    goToCheatScreen();
//  }
//
//  private void onNextBtnClicked(){
//    setQuestion(getQuestionStore().getNextQuestion());
//  }
//
//  private QuestionStore getQuestionStore() {
//    return questionStore;
//  }
//
//  private void checkToolbarVisibility(){
//
//  }
//    }
//      showAnswer();
//    } else {
//      hideAnswer();
//    if(!isAnswerVisible()) {
//  public void checkAnswerVisibility(){
//
//  }
//    checkAnswerVisibility();
//    checkToolbarVisibility();
//  public void checkVisibility(){
//
//  }
//    }
//      hideToolbar();
//    if (!isToolbarVisible()) {

  public boolean isAnswerVisible() {
  return answerVisible;
}

  public boolean isToolbarVisible() {
    return toolbarVisible;
  }

  public boolean isAnswerBtnClicked() {
    return answerBtnClicked;
  }

  public void setAnswerBtnClicked(boolean clicked) {
    answerBtnClicked = clicked;
  }

  public void  setToolbarVisible(boolean Visible){
    toolbarVisible = Visible;
  }

  public void setAnswerVisibility(boolean visible) {
    answerVisible = visible;
  }

  public void hideAnswer() {
    labelAnswer.setVisibility(View.INVISIBLE);
  }

  public void hideToolbar() {
    toolbarScreen.setVisibility(View.GONE);
  }

  public void setAnswer(String text) {
    labelAnswer.setText(text);
  }

  public void setCheatButton(String label) {
    buttonCheat.setText(label);
  }

  public void setFalseButton(String label) {
    buttonFalse.setText(label);
  }

  public void setNextButton(String label) {
    buttonNext.setText(label);
  }

  public void setQuestion(String text) {
    labelQuestion.setText(text);
  }

  public void setTrueButton(String label) {
    buttonTrue.setText(label);
  }

  public void showAnswer() {
    labelAnswer.setVisibility(View.VISIBLE);
  }

//  private boolean isAnswerBtnClicked() {
//    return quizApp.isAnswerBtnClicked();
//  }
//
//  private void setAnswerBtnClicked(boolean clicked) {
//    quizApp.setAnswerBtnClicked(clicked);
//  }
//
//  private QuestionStore getQuestionStore() {
//    return quizApp.getQuestionStore();
//  }
//
//  private boolean isToolbarVisible() {
//    return quizApp.isToolbarVisible();
//  }
//
//  private void setAnswerVisibility(boolean visible) {
//    quizApp.setAnswerVisibility(visible);
//  }
//
//  private boolean isAnswerVisible() {
//    return quizApp.isAnswerVisible();
//  }
//
//  private void goToCheatScreen(){
//    startActivity(new Intent(this, CheatView.class));
//    //quizApp.goToCheatScreen(this);
//  }

}
