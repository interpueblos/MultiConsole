package com.example.aske.multiconsole.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aske.multiconsole.data.bd.MultiConsoleSQLiteHelper;
import com.example.aske.multiconsole.data.entities.Videogame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abasurto on 20/10/2016.
 */

public class VideogameRepositoryImpl implements VideogameRepository{
    public List<Videogame> getVideogames(Context context) {
        return initVideogames(context);
    }

    private List<Videogame> initVideogames (Context context) {
        List<Videogame> videogames = new ArrayList<Videogame>();

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MultiConsoleSQLiteHelper mcdbh =
                new MultiConsoleSQLiteHelper(context, "DBMulticonsole", null, 1);

        SQLiteDatabase db = mcdbh.getReadableDatabase();

        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            Cursor cursor = db.rawQuery("select * from Videogame",null);

            if (cursor .moveToFirst()) {
                String screenshot = "";
                String titulo = "";
                String descripcion = "";
                int idv = 0;
                while (cursor.isAfterLast() == false) {
                    idv = cursor.getInt(cursor
                            .getColumnIndex("id"));
                    screenshot = cursor.getString(cursor
                            .getColumnIndex("screenshot"));
                    titulo = cursor.getString(cursor
                            .getColumnIndex("titulo"));
                    descripcion = cursor.getString(cursor
                            .getColumnIndex("descripcion"));

                    videogames.add(new Videogame(idv, screenshot,titulo,descripcion));

                    cursor.moveToNext();
                }
            }

            //Cerramos la base de datos
            db.close();
        }

        /*videogames.add(new Videogame("a1942","1942","Videojuego shoot em up"));
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
*/
        return videogames;
    }

    public Videogame getVideogame (Context context, int id) {
        Videogame videogame = null;

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MultiConsoleSQLiteHelper mcdbh =
                new MultiConsoleSQLiteHelper(context, "DBMulticonsole", null, 1);

        SQLiteDatabase db = mcdbh.getReadableDatabase();

        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            Cursor cursor = db.rawQuery("select * from Videogame where id="+id,null);

            if (cursor .moveToFirst()) {
                String screenshot = "";
                String titulo = "";
                String descripcion = "";
                String compania = "";
                String fecha = "";
                String plataforma = "";
                int idv = 0;
                while (cursor.isAfterLast() == false) {
                    idv = cursor.getInt(cursor
                            .getColumnIndex("id"));
                    screenshot = cursor.getString(cursor
                            .getColumnIndex("screenshot"));
                    titulo = cursor.getString(cursor
                            .getColumnIndex("titulo"));
                    descripcion = cursor.getString(cursor
                            .getColumnIndex("descripcion"));
                    compania = cursor.getString(cursor
                            .getColumnIndex("compania"));
                    fecha = cursor.getString(cursor
                            .getColumnIndex("fecha"));
                    plataforma = cursor.getString(cursor
                            .getColumnIndex("plataforma"));

                    videogame = new Videogame(idv, screenshot,titulo,descripcion);
                    videogame.setCompañia(compania);
                    videogame.setFecha(fecha);
                    videogame.setPlataforma(plataforma);

                    cursor.moveToNext();
                }
            }

            //Cerramos la base de datos
            db.close();
        }

        return videogame;
    }
}
