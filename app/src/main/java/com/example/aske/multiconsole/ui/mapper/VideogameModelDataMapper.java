package com.example.aske.multiconsole.ui.mapper;

import com.example.aske.multiconsole.data.entities.Videogame;
import com.example.aske.multiconsole.ui.model.VideogameModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by abasurto on 20/10/2016.
 */

@Singleton
public class VideogameModelDataMapper {

    @Inject
    public VideogameModelDataMapper() {

    }

    public VideogameModel transform(Videogame videogame) {
        VideogameModel model = new VideogameModel(videogame.getId());
        model.setTitulo(videogame.getTitulo());
        model.setScreeshot(videogame.getScreenshot());
        model.setDescripcion(videogame.getDescripcion());
        return model;
    }

    public Collection<VideogameModel> transform(Collection<Videogame> videogamesCollection) {
        Collection<VideogameModel> videogameModelsCollection;
        if (videogamesCollection != null && !videogamesCollection.isEmpty()) {
            videogameModelsCollection = new ArrayList<>();
            for (Videogame p : videogamesCollection) {
                videogameModelsCollection.add(transform(p));
            }
        } else {
            videogameModelsCollection = Collections.emptyList();
        }
        return videogameModelsCollection;
    }

}
