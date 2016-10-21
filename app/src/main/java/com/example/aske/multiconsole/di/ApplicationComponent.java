package com.example.aske.multiconsole.di;

import com.example.aske.multiconsole.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abasurto on 20/10/2016.
 */

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    void inject(MainActivity target);
}
