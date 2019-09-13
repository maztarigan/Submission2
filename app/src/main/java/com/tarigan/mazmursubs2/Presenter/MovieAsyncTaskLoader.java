package com.tarigan.mazmursubs2.Presenter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.tarigan.mazmursubs2.Model.Movie;

import java.util.ArrayList;

public class MovieAsyncTaskLoader extends AsyncTaskLoader<ArrayList<Movie>> {
    public MovieAsyncTaskLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public ArrayList<Movie> loadInBackground() {
        return null;
    }
}
