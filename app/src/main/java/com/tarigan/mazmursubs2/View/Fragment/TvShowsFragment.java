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
import android.widget.ProgressBar;

import com.tarigan.mazmursubs2.Presenter.TvShowAsyncTaskLoader;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.Model.TvShow;
import com.tarigan.mazmursubs2.View.Activity.DetailTvShow;
import com.tarigan.mazmursubs2.Adapter.ListTvShowAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<TvShow>> {
    private RecyclerView rvTvShow;
    private ListTvShowAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        adapter = new ListTvShowAdapter();
        adapter.notifyDataSetChanged();

        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTvShow.setAdapter(adapter);
        adapter.setOnItemClickCallback(new ListTvShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShow data) {
                showLoading(true);
                showSelectedTvShow(data);
                showLoading(false);
            }
        });

        progressBar = view.findViewById(R.id.progressBar);

        Bundle bundle = new Bundle();
        getLoaderManager().initLoader(0, bundle, this);

    }

    private void showSelectedTvShow(TvShow data) {
        Intent DetailMovieIntent = new Intent(getContext(), DetailTvShow.class);
        DetailMovieIntent.putExtra(DetailTvShow.EXTRA_TVSHOW, (Parcelable) data);
        startActivity(DetailMovieIntent);
    }

    @NonNull
    @Override
    public Loader<ArrayList<TvShow>> onCreateLoader(int id, @Nullable Bundle args) {
        showLoading(true);
        return new TvShowAsyncTaskLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<TvShow>> loader, ArrayList<TvShow> data) {
        showLoading(false);
        adapter.setData(data);
    }

    private void showLoading(boolean state) {
        if(state){
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<TvShow>> loader) {
        adapter.setData(null);
    }
}
