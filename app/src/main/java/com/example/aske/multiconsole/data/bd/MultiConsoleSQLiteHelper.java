package com.example.aske.multiconsole.data.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.aske.multiconsole.data.bd.MultiConsoleContract.MultiConsole;

/**
 * Created by interpueblos on 22/10/16.
 */

public class MultiConsoleSQLiteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MultiConsole.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_VIDEOGAME =
            "CREATE TABLE " + MultiConsole.TABLE_NAME + " (" +
                    MultiConsole._ID + " INTEGER PRIMARY KEY," +
                    MultiConsole.COLUMN_NAME_SCREENSHOT + TEXT_TYPE + COMMA_SEP +
                    MultiConsole.COLUMN_NAME_TITULO + TEXT_TYPE + COMMA_SEP +
                    MultiConsole.COLUMN_NAME_DESCRIPCION + TEXT_TYPE + COMMA_SEP +
                    MultiConsole.COLUMN_NAME_COMPANIA + TEXT_TYPE + COMMA_SEP +
                    MultiConsole.COLUMN_NAME_FECHA + TEXT_TYPE + COMMA_SEP +
                    MultiConsole.COLUMN_NAME_PLATAFORMA + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MultiConsole.TABLE_NAME;

    public MultiConsoleSQLiteHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(SQL_CREATE_VIDEOGAME);
        initValues(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        //Se crea la nueva versión de la tabla
        db.execSQL(SQL_DELETE_ENTRIES);
    }

    public void initValues(SQLiteDatabase db) {
        String sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (1,'a1942','1942','1942 es un videojuego shoot em up desarrollado por " +
                "Capcom que fue lanzado para máquinas recreativas en 1984. Fue el primer juego de la " +
                "serie 19XX. Fue seguido por 1943: The Battle of Midway','CAPCOM','1984','Arcade, NES, MSX, Spectrum, C64') ";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (2,'amidar','Amidar','Amidar es un abstracto juego en donde los jugadores deben " +
                "\"colorear\" todos los rectángulos que aparecen en la pantalla.','Konami','1981','Arcade, Atari 2600') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (3,'arkanoid','Arkanoid','Arkanoid es un videojuego de arcade desarrollado " +
                "por Taito en 1986. Está basado en los Breakout de Atari de los años 70.','Taito'," +
                "'1986','Arcade, C64, Amiga, Amstrad, Spectrum, NES, SNES') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (4,'asteroidsdeluxe','Asteroids deluxe','Asteroids deluxe es un juego arcade " +
                "secuela de Asteroids','Atari Inc.','1981','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (5,'bubbles','Bubbles','Bubbles es un videojuego arcade cuyo objetivo es " +
                "progresar a través de los niveles de limpieza del fregadero, evitando enemigos'" +
                ",'Williams Electronics','1982','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (6,'burgertime','Burger time','Burgertime pone al jugador en el rol de un " +
                "chef (\"Peter Pepper\") quien debe dejar caer partes de hamburguesas hacia sus " +
                "bandejas caminando sobre ellas','Data East','1982','Arcade, Atari 2600, Atari 5200, " +
                "C64, NES, Game Boy') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (7,'burninrubber','Burnin rubber','En burnin rubber el objetivo es conducir " +
                "desde el principio al final de un nivel, estrellando los vehículos " +
                "enemigos con obstáculos y saltando los diversos obstáculos de agua.','Data East'," +
                "'1982','Arcade') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (8,'cabal','Cabal','En este juego, el jugador controla a un comando, visto " +
                "desde atrás, tratando de destruir varias bases militares enemigas','TAD Corporation'" +
                ",'1988','Arcade, Amiga, Amstrad, C64, Spectrum, DOS, NES') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (9,'centipede','Centipede','Juego marcianitos donde se debe disparar a insectos " +
                "en un campo de hongos','Atari','1980','Arcade, Atari 2600, Atari 5200, Atari 7800," +
                "C64, ColecoVision, Game Boy') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (10,'columns','Columns','Columns es un videojuego arcade del género puzzle " +
                "muy similar a Tetris','Sega','1990','Arcade, Game Boy, Master System, Mega Drive, " +
                "Game Gear, Saturn, MSX 2') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (11,'commando','Commando','Commando es un juego arcade del género shoot em " +
                "up de desplazamiento vertical','Capcom','1985','Arcade, NES, Atari 2600, Atari 7800, " +
                "Spectrum, MSX, Amstrad, C64, Play Station 3') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (12,'a1943','1943','1943: The Battle of Midway  es un videojuego shoot em up  " +
                "desarrollado por Capcom y lanzado inicialmente para máquinas recreativas en 1987'," +
                "'CAPCOM','1987','Arcade, Amiga, Amstrad, C64, NES, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (13,'digdug','Dig dug','Dig Dug es un juego en donde el jugador debe excavar " +
                "túneles bajo tierra y usar una bomba de aire para inflar y hacer explotar numerosos enemigos'," +
                "'NAMCO','1982','Arcade, Atari 2600, C64, NES, Game Boy') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (14,'donkeykong','Donkey kong','Donkey kong es un primitivo juego del género " +
                "plataformas que se centra en controlar al personaje sobre una serie de plataformas " +
                "mientras evita obstáculos'," +
                "'Nintendo','1981','Arcade, Atari 2600, Amstrad, C64, MSX, NES, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (15,'dkong3','Donkey kong 3','En donkey kong 3 el jugador maneja a un pequeño " +
                "hombre con un insecticida en aerosol, mientras Donkey Kong está subido en dos ramas " +
                "de un árbol de la que cuelgan dos colmenas de donde salen constantemente abejas'," +
                "'Nintendo','1986','Arcade, NES') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (16,'donkeykongjr','Donkey kong jr','En Donkey kong jr  Mario tiene prisionero " +
                "a Donkey Kong (única ocasión en la que Mario ha sido antagonista), y su hijo, " +
                " un pequeño gorila llamado Donkey Kong Jr., tiene que rescatarlo'," +
                "'CAPCOM','1982','Arcade, Atari 2600, NES, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (17,'elevatoraction','Elevator action','Elevator action es un juego que mezcla " +
                "acción y plataformas'," +
                "'Taito','1983','Arcade, Game Boy, Amstrad, C64, MSX, NES, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (18,'frenzy','Frenzy','El objetivo del juego es sobrevivir el mayor tiempo " +
                "posible y ganar puntos por matar a los robots mientras viaja desde una habitación a otra'," +
                "'Stern Electronics','1982','Arcade, ColecoVision, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (19,'frogger','Frogger','El objetivo del juego es guiar una rana hasta su hogar. " +
                "Para hacerlo, la rana debe evitar coches mientras cruza una carretera congestionada " +
                "y luego cruzar un río lleno de riesgos'," +
                "'Konami','1981','Amstrad, Atari 2600, Atari 5200, C64, Spectrum') ";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO Videogame (_id,screenshot,titulo,descripcion, compania,fecha, plataforma)" +
                " VALUES (20,'exerion','Exerion','Exerion es un juego shoot em up con efectos de " +
                "parallax y simulación de inercia'," +
                "'Jaleco TOSE','1987','Arcade, MSX, NES') ";
        db.execSQL(sqlInsert);



    }

}
