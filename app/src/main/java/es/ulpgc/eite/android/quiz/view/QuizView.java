package es.ulpgc.eite.android.quiz.view;

import es.ulpgc.eite.android.quiz.presenter.QuizPresenter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.android.quiz.CheatActivity;
import es.ulpgc.eite.android.quiz.QuestionStore;
import es.ulpgc.eite.android.quiz.R;

/**
 * Created by User on 05/02/2017.
 */

public class QuizView  extends AppCompatActivity {

    private boolean toolbarVisible;
    private boolean answerVisible;
    private QuestionStore questionStore;
    private boolean answerBtnClicked;
    private QuizPresenter presenter;

    private Toolbar toolbarScreen;
    private Button buttonTrue, buttonFalse, buttonCheat, buttonNext;
    private TextView labelQuestion, labelAnswer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        presenter = new QuizPresenter();

        labelQuestion = (TextView) findViewById(R.id.labelQuestion);
        labelAnswer = (TextView) findViewById(R.id.labelAnswer);

        toolbarScreen = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarScreen);

        buttonTrue = (Button) findViewById(R.id.buttonTrue);
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onTrueBtnClicked();
            }
        });

        buttonFalse = (Button) findViewById(R.id.buttonFalse);
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {presenter.onFalseBtnClicked();
            }
        });

        buttonCheat = (Button) findViewById(R.id.buttonCheat);
        buttonCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { presenter.onCheatBtnClicked();
            }
        });

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onNextBtnClicked();
            }
        });

        //Falta el OnScreenStarted() que es el metodo que carga la primera pregunta
    }
}
