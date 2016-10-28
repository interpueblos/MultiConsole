package com.example.aske.multiconsole.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aske.multiconsole.data.bd.MultiConsoleContract;
import com.example.aske.multiconsole.data.bd.MultiConsoleSQLiteHelper;
import com.example.aske.multiconsole.data.entities.Videogame;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

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
                new MultiConsoleSQLiteHelper(context);

        SQLiteDatabase db = mcdbh.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                MultiConsoleContract.MultiConsole._ID,
                MultiConsoleContract.MultiConsole.COLUMN_NAME_SCREENSHOT,
                MultiConsoleContract.MultiConsole.COLUMN_NAME_TITULO,
                MultiConsoleContract.MultiConsole.COLUMN_NAME_DESCRIPCION
        };

        // Filter results WHERE "title" = 'My Title'
        //String selection = MultiConsoleContract.MultiConsole.COLUMN_NAME_TITULO + " = ?";
        //String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                MultiConsoleContract.MultiConsole.COLUMN_NAME_TITULO + " ASC";


        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            //Cursor cursor = db.rawQuery("select * from Videogame",null);

            Cursor cursor = db.query(
                    MultiConsoleContract.MultiConsole.TABLE_NAME,                     // The table to query
                    projection,                             // The columns to return
                    null,                                   // The columns for the WHERE clause
                    null,                                   // The values for the WHERE clause
                    null,                                   // don't group the rows
                    null,                                   // don't filter by row groups
                    sortOrder                               // The sort order
            );

            if (cursor .moveToFirst()) {
                String screenshot = "";
                String titulo = "";
                String descripcion = "";
                int idv = 0;
                while (cursor.isAfterLast() == false) {
                    idv = cursor.getInt(cursor
                            .getColumnIndex("_id"));
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
            cursor.close();;
            //Cerramos la base de datos
            db.close();
        }

        return videogames;
    }

    public Videogame getVideogame (Context context, int id) {
        Videogame videogame = null;

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        MultiConsoleSQLiteHelper mcdbh =
                new MultiConsoleSQLiteHelper(context);

        SQLiteDatabase db = mcdbh.getReadableDatabase();



        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            Cursor cursor = db.rawQuery("select * from Videogame where _id="+id,null);

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
                            .getColumnIndex("_id"));
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

        //MongoClientURI uri = new MongoClientURI( "mongodb://username:password@www.example.com:12345/db-name" );
        //MongoClientURI uri = new MongoClientURI( "mongodb://localhost:27017/MultiConsole" );
        //MongoClient mongoClient = new MongoClient(uri);
        MongoClient mongoClient = new MongoClient();
        MongoDatabase dbMongo = mongoClient.getDatabase("MultiConsole");
        MongoCollection<Document> coll = dbMongo.getCollection("videogame");

        //Document first = coll.find(new Document("_id",1)).first();

        return videogame;
    }
}
