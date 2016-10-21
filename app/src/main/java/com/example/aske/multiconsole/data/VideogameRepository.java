package com.example.aske.multiconsole.data;

import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public interface VideogameRepository {

    List<Videogame> getVideogames();
}
