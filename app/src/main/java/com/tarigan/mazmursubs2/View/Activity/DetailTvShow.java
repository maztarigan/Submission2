package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.Model.TvShow;

public class DetailTvShow extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private TextView tvName, tvDescription;
    private ImageView tvPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        tvName = findViewById(R.id.txt_name);
        tvDescription = findViewById(R.id.txt_descripton);
        tvPhoto = findViewById(R.id.img_photo);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        String name = tvShow.getName();
        String description = tvShow.getDesc();
        String photo = tvShow.getPhoto();

        tvName.setText(name);
        tvDescription.setText(description);
        Glide.with(this)
                .load(photo)
                .into(tvPhoto);
    }
}
