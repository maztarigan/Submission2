package com.tarigan.mazmursubs2.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME ="dbfavorite";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_MOVIE = String.format(
            "CREATE TABLE %s" +
                    " (%s INTEGER PRIMARY KEY,"+
                    " %s TEXT NOT NULL,"+
                    " %s TEXT NOT NULL,"+
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_MOVIE,
            DatabaseContract.MovieCloumns._ID,
            DatabaseContract.MovieCloumns.NAME,
            DatabaseContract.MovieCloumns.PHOTO,
            DatabaseContract.MovieCloumns.DESC
    );


    private static final String SQL_CREATE_TABLE_TVSHOWS = String.format(
            "CREATE TABLE %s" +
                    " (%s INTEGER PRIMARY KEY,"+
                    " %s TEXT NOT NULL,"+
                    " %s TEXT NOT NULL,"+
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_TVSHOWS,
            DatabaseContract.TvShowCloumns._ID,
            DatabaseContract.TvShowCloumns.NAME,
            DatabaseContract.TvShowCloumns.PHOTO,
            DatabaseContract.TvShowCloumns.DESC
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_MOVIE);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_TVSHOWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_MOVIE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_TVSHOWS);
        onCreate(sqLiteDatabase);
    }
}
