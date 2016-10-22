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
                " VALUES (1,'a1942','1942','Videojuego shoot em up','','','') ";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (2,'amidar','Amidar','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (3,'arkanoid','Arkanoid','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (4,'asteroidsdeluxe','Asteroids deluxe','Popular videojuego','','','') ";

        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (5,'bubbles','Bubbles','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (6,'burgertime','Burger time','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (7,'burninrubber','Burnin rubber','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (8,'cabal','Cabal','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (9,'centipede','Centipede','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (10,'columns','Columns','Popular videojuego','','','') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (11,'commando','Commando','Popular videojuego','','','') ";
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
