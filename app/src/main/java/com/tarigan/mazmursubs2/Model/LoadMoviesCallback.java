package com.tarigan.mazmursubs2.Model;

import java.util.ArrayList;

public abstract class LoadMoviesCallback {
    public abstract void preExecute();
    public abstract void postExecute(ArrayList<Movie> movies);
}
