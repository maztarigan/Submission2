package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.tarigan.mazmursubs2.Adapter.FavoriteTvShowAdapter;
import com.tarigan.mazmursubs2.Adapter.ListTvShowAdapter;
import com.tarigan.mazmursubs2.Db.TvShowHelper;
import com.tarigan.mazmursubs2.Model.TvShow;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.View.LoadTvShowCallback;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FavoriteTvShows extends AppCompatActivity implements LoadTvShowCallback {
    private RecyclerView rvTvShow;
    private ProgressBar progressBar;
    private static final String EXTRA_STATE = "EXTRA_STATE";

    private FavoriteTvShowAdapter adapter;
    private TvShowHelper tvShowHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_tv_shows);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.title_favorite_tvshow);

        rvTvShow = findViewById(R.id.rv_tvshow);
        rvTvShow.setLayoutManager(new LinearLayoutManager(this));
        rvTvShow.setHasFixedSize(true);

        tvShowHelper = TvShowHelper.getINSTANCE(getApplicationContext());
        tvShowHelper.open();



        progressBar = findViewById(R.id.progressBar);

        adapter = new FavoriteTvShowAdapter(this);
        adapter.setOnItemClickCallback(new ListTvShowAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TvShow data) {
                showLoading(true);
                showSelectedTvShow(data);
                showLoading(false);
            }

        });
        rvTvShow.setAdapter(adapter);

        if (savedInstanceState == null){
            new FavoriteTvShows.LoadTvShowsAsync(tvShowHelper, this).execute();
        }else {
            ArrayList<TvShow> list = savedInstanceState.getParcelableArrayList(EXTRA_STATE);
            if (list != null){
                adapter.setListTvShow(list);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_STATE, adapter.getListTvShow());
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
    public void postExecute(ArrayList<TvShow> tvShows) {
        progressBar.setVisibility(View.INVISIBLE);
        adapter.setListTvShow(tvShows);
    }

    private static class LoadTvShowsAsync extends AsyncTask<Void, Void, ArrayList<TvShow>> {
        private final WeakReference<TvShowHelper> weakTvShowHelper;
        private final WeakReference<LoadTvShowCallback> weakCallback;

        public LoadTvShowsAsync(TvShowHelper tvShowHelper, LoadTvShowCallback callback ) {
            weakTvShowHelper = new WeakReference<>(tvShowHelper);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakCallback.get().preExecute();
        }

        @Override
        protected ArrayList<TvShow> doInBackground(Void... voids) {
            return weakTvShowHelper.get().getAllTvShow();
        }

        @Override
        protected void onPostExecute(ArrayList<TvShow> tvShows) {
            super.onPostExecute(tvShows);
            weakCallback.get().postExecute(tvShows);
        }
    }

    private void showLoading(boolean state) {
        if(state){
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
    private void showSelectedTvShow(TvShow data) {
        Intent DetailTvShowIntent = new Intent(this, DetailTvShow.class);
        DetailTvShowIntent.putExtra(DetailTvShow.EXTRA_TVSHOW, data);
        startActivity(DetailTvShowIntent);
    }
}
