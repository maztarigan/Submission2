package com.tarigan.mazmursubs2.View.Activity;

import android.view.View;

public class MovieOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;

    public MovieOnItemClickListener(int position, OnItemClickCallback onItemClickCallBack){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }

    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }
}
