package com.tarigan.mazmursubs2.Presenter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;
import com.tarigan.mazmursubs2.BuildConfig;
import com.tarigan.mazmursubs2.Model.TvShow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TvShowAsyncTaskLoader extends AsyncTaskLoader<ArrayList<TvShow>> {
    private ArrayList<TvShow> mData;
    private boolean mHasResult = false;

    public TvShowAsyncTaskLoader(final Context context) {
        super(context);

        onContentChanged();
    }

    @Override
    protected void onStartLoading(){
        if(takeContentChanged())
            forceLoad();
        else if(mHasResult)
            deliverResult(mData);
    }

    @Override
    public void deliverResult(final ArrayList<TvShow> data){
        mData = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset(){
        super.onReset();
        onStopLoading();
        if(mHasResult){
            mData = null;
            mHasResult = false;
        }
    }

    private static final String API_KEY = BuildConfig.API_KEY;;

    @Nullable
    @Override
    public ArrayList<TvShow> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();

        final ArrayList<TvShow> tvShowses = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/tv?api_key="+API_KEY+"&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart(){
                super.onStart();
                setUseSynchronousMode(true);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for(int i =0; i < list.length(); i++){
                        JSONObject tvshowss = list.getJSONObject(i);
                        TvShow tvShow = new TvShow(tvshowss);
                        tvShowses.add(tvShow);
                    }
                } catch (JSONException e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });

        return tvShowses;
    }
}
