package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tarigan.mazmursubs2.R;

public class FavoriteTvShows extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_tv_shows);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.title_favorite_tvshow);
    }
}
