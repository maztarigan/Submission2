package com.tarigan.mazmursubs2.Presenter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

public class TvShowAsyncTaskLoader extends AsyncTaskLoader<ArrayList<TvShow>> {
    private ArrayList<TvShow> tvShows;
    private boolean mHasResult = false;

    public TvShowAsyncTaskLoader(final Context context) {
        super(context);

        onContentChanged();
    }

    @Override
    protected void onStartLoading(){
        if(takeContentChanged())
            forceLoad();
        else if(mHasResult)
            deliverResult(tvShows);
    }

    @Override
    public void deliverResult(final ArrayList<TvShow> data){
        tvShows = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset(){
        super.onReset();
        onStopLoading();
        if(mHasResult){
            tvShows = null;
            mHasResult = false;
        }
    }

    private static final String API_KEY = "masukkan api key";

    @Nullable
    @Override
    public ArrayList<TvShow> loadInBackground() {
        return null;
    }
}
