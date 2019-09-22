package com.tarigan.mazmursubs2.Model;

import java.util.ArrayList;

public interface LoadMoviesCallback {
    void preExecute();
    void postExecute(ArrayList<Movie> movies);
}
