package com.tarigan.mazmursubs2.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tarigan.mazmursubs2.Movie;
import com.tarigan.mazmursubs2.R;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvName, tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

//        Rekomendasi reviewer ubah menjadi variabel lokal
        ImageView tvPhoto;

        tvName = findViewById(R.id.txt_name);
        tvDescription = findViewById(R.id.txt_descripton);
        tvPhoto = findViewById(R.id.img_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String name = movie.getName();
//        Rekomendasi reviewer untuk menghindari kode yg berpotensi NullPointerException
        if (movie != null) {
            String description = movie.getDesc();
            String photo = movie.getPhoto();

            tvName.setText(name);
            tvDescription.setText(description);
            Glide.with(this)
                    .load(photo)
                    .into(tvPhoto);
        }
    }
}
