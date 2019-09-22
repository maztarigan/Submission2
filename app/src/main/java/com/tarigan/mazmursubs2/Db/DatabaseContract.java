package com.tarigan.mazmursubs2.Db;

import android.provider.BaseColumns;

public class DatabaseContract {
    static String TABLE_MOVIE ="movie";
    static String TABLE_TVSHOWS ="tvshow";

    static final class MovieCloumns implements BaseColumns{
//        static String _ID ="id";
        static String NAME="name";
        static String PHOTO = "photo";
        static String DESC = "desc";
    }

    static final class TvShowCloumns implements BaseColumns{
//        static String _ID ="id";
        static String NAME="name";
        static String PHOTO = "photo";
        static String DESC = "desc";
    }
}
