package es.ulpgc.eite.android.quiz.Mediator;

import android.app.Application;

import es.ulpgc.eite.android.quiz.model.QuestionStore;
import es.ulpgc.eite.android.quiz.presenter.QuizPresenter;
import es.ulpgc.eite.android.quiz.view.QuizView;

/**
 * Created by Pedro Arenas on 10/2/17.
 */


public class QuizMediator extends Application {

    private QuizPresenter presenter;
    private QuestionStore model;
    private QuizView view;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public QuizPresenter getPresenter() {
        return presenter;
    }

    public QuestionStore getModel() {
        return model;
    }

    public QuizView getView() {
        return view;
    }


}
