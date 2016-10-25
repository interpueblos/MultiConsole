package com.example.aske.multiconsole.di;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aske.multiconsole.business.GetVideogamesInteractor;
import com.example.aske.multiconsole.business.GetVideogamesInteractorImpl;
import com.example.aske.multiconsole.data.VideogameRepository;
import com.example.aske.multiconsole.data.VideogameRepositoryImpl;
import com.example.aske.multiconsole.ui.DetailContract;
import com.example.aske.multiconsole.ui.DetailPresenter;
import com.example.aske.multiconsole.ui.MainContract;
import com.example.aske.multiconsole.ui.MainPresenter;
import com.example.aske.multiconsole.ui.mapper.VideogameModelDataMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abasurto on 20/10/2016.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application app) {
        this.application = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public MainContract.MainPresenter provideMainPresenter(GetVideogamesInteractor interactor,
                                                           VideogameModelDataMapper mapper) {
        return new MainPresenter(interactor, mapper);
    }

    @Provides
    @Singleton
    public GetVideogamesInteractor provideGetVideogamesInteractor(VideogameRepository repository) {
        return new GetVideogamesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    public VideogameRepository provideVideogameRepository() {
        return new VideogameRepositoryImpl();
    }

    @Singleton
    @Provides
    public RecyclerView.LayoutManager provideLayoutManager(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    @Provides
    @Singleton
    public DetailContract.DetailPresenter provideDetailPresenter(GetVideogamesInteractor interactor) {
        return new DetailPresenter(interactor);
    }

}
