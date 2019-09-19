package com.tarigan.mazmursubs2.View.Fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.Adapter.SubmissionAdapter;
import com.tarigan.mazmursubs2.View.Activity.DetailMovie;

public class MainFragment extends Fragment {
    private SubmissionAdapter submissionAdapter;
    private ViewPager viewPager;
    private static Context context;



    public static Fragment newInstance(Context contexts) {
        context = contexts;
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState){
        submissionAdapter = new SubmissionAdapter(getChildFragmentManager(), context);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(submissionAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

//        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation_favorite);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_favorite:
                    menuItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_red_24dp));
//                    Intent intent = new Intent(context, DetailMovie.class);
//                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

}
