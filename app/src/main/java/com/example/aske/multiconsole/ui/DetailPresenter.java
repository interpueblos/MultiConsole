package com.example.aske.multiconsole.ui;

import android.content.Context;

import com.example.aske.multiconsole.business.GetVideogamesInteractor;
import com.example.aske.multiconsole.data.entities.Videogame;

/**
 * Created by abasurto on 24/10/2016.
 */

public class DetailPresenter implements DetailContract.DetailPresenter {
    private GetVideogamesInteractor getVideogamesInteractor;
    private DetailContract.DetailView view;
    private Videogame videogame;

    public DetailPresenter(GetVideogamesInteractor getVideogamesInteractor) {
        this.getVideogamesInteractor = getVideogamesInteractor;
        videogame = new Videogame();
    }

    @Override
    public void attachView(DetailContract.DetailView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void init(Context context, int id) {
        view.renderVideogame(getVideogamesInteractor.getVideogame(context, id));
    }
}
