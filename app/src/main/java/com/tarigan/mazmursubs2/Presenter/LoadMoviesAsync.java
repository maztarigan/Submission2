package com.tarigan.mazmursubs2.Presenter;

import android.os.AsyncTask;

import com.tarigan.mazmursubs2.Db.MovieHelper;
import com.tarigan.mazmursubs2.Model.LoadMoviesCallback;
import com.tarigan.mazmursubs2.Model.Movie;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class LoadMoviesAsync extends AsyncTask<Void, Void, ArrayList<Movie>> {
    private final WeakReference<MovieHelper> weakMovieHelper = null;
    private final WeakReference<LoadMoviesCallback> weakCallback = null;

    public LoadMoviesAsync(WeakReference<MovieHelper> weakMovieHelper, WeakReference<LoadMoviesCallback> weakCallback) {
        this.weakMovieHelper = new WeakReference<>(weakMovieHelper);
        this.weakCallback = new WeakReference<LoadMoviesCallback>;
    }

    @Override
    protected ArrayList<Movie> doInBackground(Void... voids) {
        return weakMovieHelper.get();
    }
}
