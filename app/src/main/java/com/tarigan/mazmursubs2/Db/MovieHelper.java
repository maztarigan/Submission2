package com.tarigan.mazmursubs2.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tarigan.mazmursubs2.Model.Movie;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.MovieCloumns.DESC;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.MovieCloumns.NAME;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.MovieCloumns.PHOTO;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.TABLE_MOVIE;

public class MovieHelper {
    private static final String DATABASE_TABLE = TABLE_MOVIE;
    private static DatabaseHelper databaseHelper;
    private static MovieHelper INSTANCE;

    private static SQLiteDatabase database;

    public MovieHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static MovieHelper getINSTANCE(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                    INSTANCE = new MovieHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException{
        database = databaseHelper.getWritableDatabase();
    }

    public void close(){
        databaseHelper.close();

        if(database.isOpen())
            database.close();
    }

    public ArrayList<Movie> getAllMovies(){
        ArrayList<Movie> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        Movie movie;
        if (cursor.getCount() > 0){
            do {
                movie = new Movie();
                movie.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                movie.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
                movie.setPhoto(cursor.getString(cursor.getColumnIndexOrThrow(PHOTO)));
                movie.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(DESC)));

                arrayList.add(movie);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long searchMovie(String name){
        int total;
        Cursor cursor = database.query(DATABASE_TABLE, null,
                "NAME = '"+name+"'",
                null,
                null,
                null,
                null,
                null
        );
        total = cursor.getCount();
        cursor.close();
        return total;
    }

    public long insertMovie(Movie movie){
        ContentValues args = new ContentValues();
        args.put(NAME, movie.getName());
        args.put(PHOTO, movie.getPhoto());
        args.put(DESC, movie.getDesc());
        return database.insert(DATABASE_TABLE, null, args);
    }

    public long updateMovie(Movie movie){
        ContentValues args = new ContentValues();
        args.put(NAME, movie.getName());
        args.put(PHOTO, movie.getPhoto());
        args.put(DESC, movie.getDesc());
        return database.update(DATABASE_TABLE, args, _ID +"= '"+movie.getId()+"'",null);
    }

    public int deleteMovie (String name){
        return database.delete(TABLE_MOVIE, NAME +" = '"+name+"'",null);
    }
}
