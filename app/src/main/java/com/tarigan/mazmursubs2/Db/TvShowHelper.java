package com.tarigan.mazmursubs2.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.TABLE_TVSHOWS;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.TvShowCloumns.DESC;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.TvShowCloumns.NAME;
import static com.tarigan.mazmursubs2.Db.DatabaseContract.TvShowCloumns.PHOTO;

public class TvShowHelper {
    private static final String DATABASE_TABLE = TABLE_TVSHOWS;
    private static DatabaseHelper databaseHelper;
    private static TvShowHelper INSTANCE;

    private static SQLiteDatabase database;

    public TvShowHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static TvShowHelper getINSTANCE(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                    INSTANCE = new TvShowHelper(context);
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

        if (database.isOpen())
            database.close();
    }

    public ArrayList<TvShow> getAllTvShow(){
        ArrayList<TvShow> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE,null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        TvShow tvShow;
        if(cursor.getCount() >0){
            do {
                tvShow = new TvShow();
                tvShow.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                tvShow.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
                tvShow.setPhoto(cursor.getString(cursor.getColumnIndexOrThrow(PHOTO)));
                tvShow.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(DESC)));

                arrayList.add(tvShow);
                cursor.moveToNext();

            }while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insertTvShow(TvShow tvShow){
        ContentValues args = new ContentValues();
        args.put(_ID, tvShow.getId());
        args.put(NAME, tvShow.getName());
        args.put(PHOTO, tvShow.getPhoto());
        args.put(DESC, tvShow.getDesc());
        return database.insert(DATABASE_TABLE, null, args);
    }

    public long updateTvShow(TvShow tvShow){
        ContentValues args = new ContentValues();
        args.put(_ID, tvShow.getId());
        args.put(NAME, tvShow.getName());
        args.put(PHOTO, tvShow.getPhoto());
        args.put(DESC, tvShow.getDesc());
        return database.update(DATABASE_TABLE, args, _ID + "= '"+ tvShow.getId()+ "'",null);
    }

    public int deleteTvShow(int id){
        return database.delete(TABLE_TVSHOWS, _ID + " = '"+id+"'",null);
    }

}
