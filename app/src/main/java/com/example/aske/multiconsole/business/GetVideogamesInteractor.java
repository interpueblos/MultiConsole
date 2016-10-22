package com.example.aske.multiconsole.business;

import android.content.Context;

import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public interface GetVideogamesInteractor {
    List<Videogame> execute(Context context);
}
