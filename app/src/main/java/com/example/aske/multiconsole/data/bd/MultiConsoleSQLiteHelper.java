package com.example.aske.multiconsole.data.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by interpueblos on 22/10/16.
 */

public class MultiConsoleSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Videogames
    String sqlCreate = "CREATE TABLE Videogame (id INTEGER, screenshot TEXT, titulo TEXT," +
            "descripcion TEXT, compania TEXT, fecha TEXT, plataforma TEXT)";


    public MultiConsoleSQLiteHelper(Context contexto, String nombre,
                                    SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
        initValues(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Videogame");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }

    public void initValues(SQLiteDatabase db) {
        String sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (1,'a1942','1942','1942 es un videojuego shoot em up desarrollado por " +
                "Capcom que fue lanzado para máquinas recreativas en 1984. Fue el primer juego de la " +
                "serie 19XX. Fue seguido por 1943: The Battle of Midway','CAPCOM','1984','Arcade, NES, MSX, Spectrum, C64') ";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (2,'amidar','Amidar','Amidar es un abstracto juego en donde los jugadores deben " +
                "\"colorear\" todos los rectángulos que aparecen en la pantalla.','Konami','1981','Arcade, Atari 2600') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (3,'arkanoid','Arkanoid','Arkanoid es un videojuego de arcade desarrollado " +
                "por Taito en 1986. Está basado en los Breakout de Atari de los años 70.','Taito'," +
                "'1986','Arcade, C64, Amiga, Amstrad, Spectrum, NES, SNES') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (4,'asteroidsdeluxe','Asteroids deluxe','Asteroids deluxe es un juego arcade " +
                "secuela de Asteroids','Atari Inc.','1981','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (5,'bubbles','Bubbles','Bubbles es un videojuego arcade cuyo objetivo es " +
                "progresar a través de los niveles de limpieza del fregadero, evitando enemigos'" +
                ",'Williams Electronics','1982','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (6,'burgertime','Burger time','Burgertime pone al jugador en el rol de un " +
                "chef (\"Peter Pepper\") quien debe dejar caer partes de hamburguesas hacia sus " +
                "bandejas caminando sobre ellas','Data East','1982','Arcade, Atari 2600, Atari 5200, " +
                "C64, NES, Game Boy') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (7,'burninrubber','Burnin rubber','En burnin rubber el objetivo es conducir " +
                "desde el principio al final de un nivel, estrellando los vehículos " +
                "enemigos con obstáculos y saltando los diversos obstáculos de agua.','Data East'," +
                "'1982','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (8,'cabal','Cabal','En este juego, el jugador controla a un comando, visto " +
                "desde atrás, tratando de destruir varias bases militares enemigas','TAD Corporation'" +
                ",'1988','Arcade, Amiga, Amstrad, C64, Spectrum, DOS, NES') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (9,'centipede','Centipede','Juego marcianitos donde se debe disparar a insectos " +
                "en un campo de hongos','Atari','1980','Arcade, Atari 2600, Atari 5200, Atari 7800," +
                "C64, ColecoVision, Game Boy') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (10,'columns','Columns','Columns es un videojuego arcade del género puzzle " +
                "muy similar a Tetris','Sega','1990','Arcade, Game Boy, Master System, Mega Drive, " +
                "Game Gear, Saturn, MSX 2') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (11,'commando','Commando','Commando es un juego arcade del género shoot em " +
                "up de desplazamiento vertical','Capcom','1985','Arcade, NES, Atari 2600, Atari 7800, " +
                "Spectrum, MSX, Amstrad, C64, Play Station 3') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (12,'a1943','1943','1943: The Battle of Midway  es un videojuego shoot em up  " +
                "desarrollado por Capcom y lanzado inicialmente para máquinas recreativas en 1987'," +
                "'CAPCOM','1987','Arcade, Amiga, Amstrad, C64, NES, Spectrum') ";
        db.execSQL(sqlInsert);



        /*videogames.add(new Videogame("digdug","Digdug","Popular videojuego de arcade."));
        videogames.add(new Videogame("donkeykong","Donkey kong","Popular videojuego de arcade."));
        videogames.add(new Videogame("dkong3","Donkey kong 3","Popular videojuego de arcade."));
        videogames.add(new Videogame("donkeykongjr","Donkey kong jr","Popular videojuego de arcade."));
        videogames.add(new Videogame("elevatoraction","Elevator action","Popular videojuego de arcade."));
        videogames.add(new Videogame("exerion","Exerion","Popular videojuego de arcade."));
        videogames.add(new Videogame("frenzy","Frenzy","Popular videojuego de arcade."));
        videogames.add(new Videogame("frogger","Frogger","Popular videojuego de arcade."));*/
    }

}
