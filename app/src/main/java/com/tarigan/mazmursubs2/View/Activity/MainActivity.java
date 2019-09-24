package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.tarigan.mazmursubs2.Db.MovieHelper;
import com.tarigan.mazmursubs2.Db.TvShowHelper;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.View.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    MovieHelper movieHelper;
    TvShowHelper tvShowHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(this))
                    .commitNow();
        }

        movieHelper = MovieHelper.getINSTANCE(getApplicationContext());
        movieHelper.open();

        tvShowHelper = TvShowHelper.getINSTANCE(getApplicationContext());
        tvShowHelper.open();

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings){
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
