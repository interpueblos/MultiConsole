package com.example.aske.multiconsole;

import android.app.Application;

import com.example.aske.multiconsole.di.ApplicationComponent;
import com.example.aske.multiconsole.di.ApplicationModule;
import com.example.aske.multiconsole.di.DaggerApplicationComponent;

/**
 * Created by abasurto on 20/10/2016.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
