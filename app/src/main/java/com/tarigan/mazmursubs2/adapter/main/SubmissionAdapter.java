package com.tarigan.mazmursubs2.adapter.main;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.fragment.MoviesFragment;
import com.tarigan.mazmursubs2.fragment.TvShowsFragment;

public class SubmissionAdapter extends FragmentStatePagerAdapter {


    public SubmissionAdapter(FragmentManager fm, Context context) {
        super(fm);

        this.context = context;

    }

    private Context context;

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



    @Override
    public CharSequence getPageTitle(int position){
        String tabTitles[] = new String[]{context.getResources().getString(R.string.title_movie),context.getResources().getString(R.string.title_tvshow)};

        return tabTitles[position];
    }

}
