package com.tarigan.mazmursubs2.ui.main;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tarigan.mazmursubs2.Movie;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.adapter.main.ListMovieAdapter;
import com.tarigan.mazmursubs2.data.main.MoviesDataEn;
import com.tarigan.mazmursubs2.data.main.MoviesDataIndo;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));

        String Language = Locale.getDefault().getLanguage();
        switch (Language){
            case "in":
                list.addAll(MoviesDataIndo.getListData());
            case "en":
                list.addAll(MoviesDataEn.getListData());
        }
        list.addAll(MoviesDataEn.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        rvMovies.setAdapter(listMovieAdapter);

        listMovieAdapter.setOnItemClickCallback(new ListMovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedMovie(data);
            }
        });
    }

    private void showSelectedMovie(Movie data) {
        Intent DetailMovieIntent = new Intent(getContext(),DetailMovie.class);
        DetailMovieIntent.putExtra(DetailMovie.EXTRA_MOVIE, data);
        startActivity(DetailMovieIntent);
    }


}
