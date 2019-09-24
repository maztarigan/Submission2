package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.tarigan.mazmursubs2.Adapter.FavoriteMovieAdapter;
import com.tarigan.mazmursubs2.Adapter.ListMovieAdapter;
import com.tarigan.mazmursubs2.Db.MovieHelper;
import com.tarigan.mazmursubs2.View.LoadMoviesCallback;
import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FavoriteMovies extends AppCompatActivity implements LoadMoviesCallback{
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

        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.setHasFixedSize(true);

        movieHelper = MovieHelper.getINSTANCE(getApplicationContext());
        movieHelper.open();



        progressBar = findViewById(R.id.progressBar);

        adapter = new FavoriteMovieAdapter(this);
        adapter.setOnItemClickCallback(new ListMovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showLoading(true);
                showSelectedMovie(data);
                showLoading(false);
            }
        });

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

    private void showLoading(boolean state) {
        if(state){
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
    private void showSelectedMovie(Movie data) {
        Intent DetailMovieIntent = new Intent(this, DetailMovie.class);
        DetailMovieIntent.putExtra(DetailMovie.EXTRA_MOVIE, data);
        startActivity(DetailMovieIntent);
    }

}
