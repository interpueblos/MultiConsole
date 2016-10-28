package com.example.aske.multiconsole.data.bd;

import android.provider.BaseColumns;

/**
 * Created by abasurto on 26/10/2016.
 */

public final class MultiConsoleContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MultiConsoleContract() {}

    /* Inner class that defines the table contents */
    public static class MultiConsole implements BaseColumns {
        public static final String TABLE_NAME = "Videogame";
        public static final String COLUMN_NAME_SCREENSHOT = "screenshot";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
        public static final String COLUMN_NAME_COMPANIA = "compania";
        public static final String COLUMN_NAME_FECHA = "fecha";
        public static final String COLUMN_NAME_PLATAFORMA = "plataforma";

    }
}

