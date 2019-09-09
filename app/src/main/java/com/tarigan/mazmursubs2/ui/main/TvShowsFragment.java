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

import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.TvShow;
import com.tarigan.mazmursubs2.adapter.main.ListTvShowAdapter;
import com.tarigan.mazmursubs2.data.main.TvShowDataEn;
import com.tarigan.mazmursubs2.data.main.TvShowDataIndo;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ArrayList<TvShow> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));

        String Language = Locale.getDefault().getLanguage();
        switch (Language){
            case "in":
                list.addAll(TvShowDataIndo.getListData());
            case "en":
                list.addAll(TvShowDataEn.getListData());
        }
        showRecyclerList();

    }

    private void showRecyclerList() {
        ListTvShowAdapter listTvShowAdapter = new ListTvShowAdapter(list);
        rvTvShow.setAdapter(listTvShowAdapter);

        listTvShowAdapter.setOnItemClickCallback(new ListTvShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShow data) {
                showSelectedTvShow(data);
            }
        });
    }

    private void showSelectedTvShow(TvShow data) {
        Intent DetailMovieIntent = new Intent(getContext(),DetailTvShow.class);
        DetailMovieIntent.putExtra(DetailTvShow.EXTRA_TVSHOW, data);
        startActivity(DetailMovieIntent);
    }

}
