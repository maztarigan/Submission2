package com.tarigan.mazmursubs2.Presenter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.tarigan.mazmursubs2.Model.Movie;

import java.util.ArrayList;

public class MovieAsyncTaskLoader extends AsyncTaskLoader<ArrayList<Movie>> {
    private  ArrayList<Movie> movies;
    private boolean mHasResult = false;

    public MovieAsyncTaskLoader(final Context context) {
        super(context);

        onContentChanged();
    }

    @Override
    protected void onStartLoading(){
        if (takeContentChanged())
            forceLoad();
        else if (mHasResult)
            deliverResult(movies);
    }

    @Override
    public void deliverResult(final ArrayList<Movie> data){
        movies = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset(){
        super.onReset();
        onStopLoading();
        if(mHasResult){
            movies = null;
            mHasResult = false;
        }
    }

    private static final String API_KEY = "masukkan api";


    @Nullable
    @Override
    public ArrayList<Movie> loadInBackground() {
        return null;
    }
}
