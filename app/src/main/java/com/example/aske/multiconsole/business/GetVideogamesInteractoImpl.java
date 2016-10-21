package com.example.aske.multiconsole.business;

import com.example.aske.multiconsole.data.VideogameRepository;
import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public class GetVideogamesInteractoImpl implements GetVideogamesInteractor{
    private VideogameRepository videogameRepository;

    public GetVideogamesInteractoImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public List<Videogame> execute() {
        return videogameRepository.getVideogames();
    }
}
