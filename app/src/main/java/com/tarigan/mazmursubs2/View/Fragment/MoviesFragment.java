package com.tarigan.mazmursubs2.View.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.Presenter.MovieAsyncTaskLoader;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.View.Activity.DetailMovie;
import com.tarigan.mazmursubs2.Adapter.ListMovieAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Movie>> {
    private RecyclerView rvMovies;
    private ListMovieAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        adapter = new ListMovieAdapter();
        adapter.notifyDataSetChanged();

        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovies.setAdapter(adapter);
        adapter.setOnItemClickCallback(new ListMovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedMovie(data);
            }
        });

        Bundle bundle = new Bundle();
        getLoaderManager().initLoader(0, bundle, this);
    }

    private void showSelectedMovie(Movie data) {
        Intent DetailMovieIntent = new Intent(getContext(), DetailMovie.class);
        DetailMovieIntent.putExtra(DetailMovie.EXTRA_MOVIE, (Parcelable) data);
        startActivity(DetailMovieIntent);
    }


    @NonNull
    @Override
    public Loader<ArrayList<Movie>> onCreateLoader(int id, @Nullable Bundle args) {
        return new MovieAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Movie>> loader, ArrayList<Movie> data) {
        adapter.setData(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Movie>> loader) {
        adapter.setData(null);
    }
}
