package com.example.aske.multiconsole.data;

import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public class VideogameRepositoryImpl implements VideogameRepository{
    public List<Videogame> getVideogames() {
        return initVideogames();
    }

    private List<Videogame> initVideogames () {
        List<Videogame> videogames = new ArrayList<Videogame>();

        videogames.add(new Videogame("a1942","1942","Videojuego shoot em up"));
        videogames.add(new Videogame("amidar","Amidar","Juego abstracto en donde los jugadores deben colorear todos los rectángulos que aparecen en la pantalla"));
        videogames.add(new Videogame("arkanoid","Arkanoid","Videojuego de arcade desarrollado por Taito en 1986. Está basado en los Breakout de Atari de los años 70."));
        videogames.add(new Videogame("asteroidsdeluxe","Asteroids deluxe","Popular videojuego de arcade basado en vectores."));
        videogames.add(new Videogame("bubbles","Bubbles","Popular videojuego de arcade."));
        videogames.add(new Videogame("burgertime","Burger time","Popular videojuego de arcade."));
        videogames.add(new Videogame("burninrubber","Burnin rubber","Popular videojuego de arcade."));
        videogames.add(new Videogame("cabal","Cabal","Popular videojuego de arcade."));
        videogames.add(new Videogame("centipede","Centipede","Popular videojuego de arcade."));
        videogames.add(new Videogame("columns","Columns","Popular videojuego de arcade."));
        videogames.add(new Videogame("commando","Commando","Popular videojuego de arcade."));
        videogames.add(new Videogame("digdug","Digdug","Popular videojuego de arcade."));
        videogames.add(new Videogame("donkeykong","Donkey kong","Popular videojuego de arcade."));
        videogames.add(new Videogame("dkong3","Donkey kong 3","Popular videojuego de arcade."));
        videogames.add(new Videogame("donkeykongjr","Donkey kong jr","Popular videojuego de arcade."));
        videogames.add(new Videogame("elevatoraction","Elevator action","Popular videojuego de arcade."));
        videogames.add(new Videogame("exerion","Exerion","Popular videojuego de arcade."));
        videogames.add(new Videogame("frenzy","Frenzy","Popular videojuego de arcade."));
        videogames.add(new Videogame("frogger","Frogger","Popular videojuego de arcade."));

        return videogames;
    }
}
