package com.example.aske.multiconsole.ui;

import android.content.Context;

import com.example.aske.multiconsole.data.entities.Videogame;

/**
 * Created by abasurto on 24/10/2016.
 */

public class DetailContract {
    interface DetailView {

        //void setLoading(boolean loading);

        void renderVideogame(Videogame videogame);
    }

    public interface DetailPresenter {

        void attachView(DetailContract.DetailView view);

        void detachView();

        void init(Context context, int id);
    }
}
