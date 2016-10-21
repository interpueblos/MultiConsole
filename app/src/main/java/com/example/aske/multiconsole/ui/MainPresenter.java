package com.example.aske.multiconsole.ui;

import com.example.aske.multiconsole.business.GetVideogamesInteractor;
import com.example.aske.multiconsole.ui.mapper.VideogameModelDataMapper;
import com.example.aske.multiconsole.ui.model.VideogameModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import rx.Subscription;

/**
 * Created by abasurto on 20/10/2016.
 */

public class MainPresenter implements MainContract.MainPresenter{

    private GetVideogamesInteractor getVideogamesInteractor;
    private VideogameModelDataMapper mapper;
    private MainContract.MainView view;
    private List<VideogameModel> videogameList;
    private Subscription subscription;


    public MainPresenter(GetVideogamesInteractor getVideogamesInteractor, VideogameModelDataMapper mapper) {
        this.getVideogamesInteractor = getVideogamesInteractor;
        this.mapper = mapper;
        videogameList = new ArrayList<VideogameModel>();
    }

    @Override
    public void attachView(MainContract.MainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }

    @Override
    public void init() {
        if (videogameList.isEmpty()) {
            view.renderVideogames((List)mapper.transform((Collection)getVideogamesInteractor.execute()));
        } else {
            if (view != null) {
                view.renderVideogames(videogameList);
            }
        }
    }

    private void setLoading(boolean loading) {

    }

}

