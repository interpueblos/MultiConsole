package com.example.aske.multiconsole.business;

import android.content.Context;

import com.example.aske.multiconsole.data.VideogameRepository;
import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public class GetVideogamesInteractorImpl implements GetVideogamesInteractor{
    private VideogameRepository videogameRepository;

    public GetVideogamesInteractorImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public List<Videogame> execute(Context context) {
        return videogameRepository.getVideogames(context);
    }
}
