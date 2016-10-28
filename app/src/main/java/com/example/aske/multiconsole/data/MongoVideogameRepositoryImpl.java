package com.example.aske.multiconsole.data;

import android.content.Context;

import com.example.aske.multiconsole.data.entities.Videogame;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;

/**
 * Created by abasurto on 28/10/2016.
 */

public class MongoVideogameRepositoryImpl implements VideogameRepository{

    public List<Videogame> getVideogames(Context context) {
        return initVideogames(context);
    }

    private List<Videogame> initVideogames (Context context) {

        //MongoClientURI uri = new MongoClientURI( "mongodb://username:password@www.example.com:12345/db-name" );
        MongoClientURI uri = new MongoClientURI( "mongodb://127.0.0.1:27017/MultiConsole" );
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());
        MongoCollection collectionNames = db.getCollection("videogame");

        return null;
    }

    public Videogame getVideogame (Context context, int id) {
        return null;
    }

}
