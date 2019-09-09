package com.tarigan.mazmursubs2.adapter.main;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.ui.main.MoviesFragment;
import com.tarigan.mazmursubs2.ui.main.TvShowsFragment;

public class SubmissionAdapter extends FragmentStatePagerAdapter {

    public SubmissionAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MoviesFragment();
            case 1:
                return new TvShowsFragment();
        };
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    private String tabTitles[] = new String[]{String.valueOf(R.string.title_movie), String.valueOf(R.string.title_tvshow)};
//    private String tabTitles[] = new String[]{"MOVIES", "TV SHOWS"};

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }

}
