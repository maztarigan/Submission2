package com.tarigan.mazmursubs2.Presenter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

public class TvShowAsyncTaskLoader extends AsyncTaskLoader<ArrayList<TvShow>> {
    public TvShowAsyncTaskLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public ArrayList<TvShow> loadInBackground() {
        return null;
    }
}
