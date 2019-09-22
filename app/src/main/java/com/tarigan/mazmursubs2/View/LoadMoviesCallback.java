package com.tarigan.mazmursubs2.View;

import com.tarigan.mazmursubs2.Model.Movie;

import java.util.ArrayList;

public interface LoadMoviesCallback {
    void preExecute();
    void postExecute(ArrayList<Movie> movies);
}
