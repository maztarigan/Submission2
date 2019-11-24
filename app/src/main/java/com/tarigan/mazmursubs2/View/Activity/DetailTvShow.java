package com.tarigan.mazmursubs2.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tarigan.mazmursubs2.Db.TvShowHelper;
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.Model.TvShow;

public class DetailTvShow extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private TextView tvName, tvDescription;
    private ImageView tvPhoto;
    private ImageButton imageButton;

    public static final String EXTRA_POSITION = "extra_position";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_DELETE = 301;

    private TvShow tvShow;
    private int position;

    private TvShowHelper tvShowHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        tvName = findViewById(R.id.txt_name);
        tvDescription = findViewById(R.id.txt_descripton);
        tvPhoto = findViewById(R.id.img_photo);

        tvShowHelper = TvShowHelper.getINSTANCE(getApplicationContext());
        imageButton = (ImageButton)findViewById(R.id.btn_favorite);

        final TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        if (tvShow != null){
            String name = tvShow.getName();
            String description = tvShow.getDesc();
            String photo = tvShow.getPhoto();

            tvName.setText(name);
            tvDescription.setText(description);
            Glide.with(this)
                    .load(photo)
                    .into(tvPhoto);

            position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        }

        final long searchlist = tvShowHelper.searchTvShow(tvShow.getId());
        if (searchlist > 0){
            imageButton.setImageResource(R.drawable.ic_favorite_red_24dp);
        }else {
            imageButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TvShow tvShows = new TvShow();
                tvShows.setId(tvShow.getId());
                tvShows.setName(tvShow.getName());
                tvShows.setDesc(tvShow.getDesc());
                tvShows.setPhoto(tvShow.getPhoto());

                Intent intent = new Intent();
                intent.putExtra(EXTRA_TVSHOW, tvShow);
                intent.putExtra(EXTRA_POSITION, position);

                if (searchlist >0) {
                    imageButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    long result = tvShowHelper.deleteTvShow(tvShows.getId());

                    if(result > 0 ){
                        tvShows.setId((int) result);
                        setResult(RESULT_DELETE, intent);
                    }else {
                        Toast.makeText(DetailTvShow.this, "Error",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    imageButton.setImageResource(R.drawable.ic_favorite_red_24dp);
                    long result = tvShowHelper.insertTvShow(tvShows);

                    if(result > 0 ){
                        tvShows.setId((int) result);
                        setResult(RESULT_ADD, intent);
                    }else {
                        Toast.makeText(DetailTvShow.this, "Error",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });



    }
}
