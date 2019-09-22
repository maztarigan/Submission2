package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.tarigan.mazmursubs2.Adapter.FavoriteMovieAdapter;
import com.tarigan.mazmursubs2.Db.MovieHelper;
import com.tarigan.mazmursubs2.Model.LoadMoviesCallback;
import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class FavoriteMovies extends AppCompatActivity implements LoadMoviesCallback{
    private RecyclerView rvMovies;
    private ProgressBar progressBar;
    private static final String EXTRA_STATE = "EXTRA_STATE";

    private FavoriteMovieAdapter adapter;
    private MovieHelper movieHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movies);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.title_favorite_movie);

        movieHelper = MovieHelper.getINSTANCE(getApplicationContext());

        progressBar = findViewById(R.id.progressBar);

        adapter = new FavoriteMovieAdapter(this);
        rvMovies.setAdapter(adapter);

        if (savedInstanceState == null){
            new LoadMoviesAsync(movieHelper, this).execute();
        }else {
            ArrayList<Movie> list = savedInstanceState.getParcelableArrayList(EXTRA_STATE);
            if (list != null){
                adapter.setListMovie(list);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_STATE, adapter.getListMovie());
    }

    @Override
    public void preExecute() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void postExecute(ArrayList<Movie> movies) {
        progressBar.setVisibility(View.INVISIBLE);
        adapter.setListMovie(movies);
    }

    private static class LoadMoviesAsync extends AsyncTask<Void, Void, ArrayList<Movie>> {
        private final WeakReference<MovieHelper> weakMovieHelper;
        private final WeakReference<LoadMoviesCallback> weakCallback;

        public LoadMoviesAsync(MovieHelper movieHelper, LoadMoviesCallback callback ) {
            weakMovieHelper = new WeakReference<>(movieHelper);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakCallback.get().preExecute();
        }

        @Override
        protected ArrayList<Movie> doInBackground(Void... voids) {
            return weakMovieHelper.get().getAllMovies();
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            super.onPostExecute(movies);
            weakCallback.get().postExecute(movies);
        }
    }

}
