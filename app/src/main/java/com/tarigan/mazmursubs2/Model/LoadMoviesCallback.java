package com.tarigan.mazmursubs2.Model;

import java.util.ArrayList;

public abstract class LoadMoviesCallback {
    protected abstract void preExecute();
    protected abstract void postExecute(ArrayList<Movie> movies);
}
