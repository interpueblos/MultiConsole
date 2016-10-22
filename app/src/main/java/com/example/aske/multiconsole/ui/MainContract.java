package com.example.aske.multiconsole.ui;

import android.content.Context;

import com.example.aske.multiconsole.ui.model.VideogameModel;

import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public interface MainContract {
    interface MainView {

        //void setLoading(boolean loading);

        void renderVideogames(List<VideogameModel> products);
    }

    interface MainPresenter {

        void attachView(MainContract.MainView view);

        void detachView();

        void init(Context context);
    }
}
