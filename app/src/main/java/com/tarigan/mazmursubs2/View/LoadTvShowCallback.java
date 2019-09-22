package com.tarigan.mazmursubs2.View;

import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

public interface LoadTvShowCallback {
    void preExecute();
    void postExecute(ArrayList<TvShow> tvShows);
}
