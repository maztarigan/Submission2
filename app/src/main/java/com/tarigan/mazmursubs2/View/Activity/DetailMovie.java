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
import com.tarigan.mazmursubs2.Db.MovieHelper;
import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.R;


public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tvName, tvDescription;
    private ImageButton imageButton;


    public static final String EXTRA_POSITION = "extra_position";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_DELETE = 301;

    private Movie movie;
    private int position;

    private MovieHelper movieHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ImageView tvPhoto;

        tvName = findViewById(R.id.txt_name);
        tvDescription = findViewById(R.id.txt_descripton);
        tvPhoto = findViewById(R.id.img_photo);

        movieHelper = MovieHelper.getINSTANCE(getApplicationContext());


        imageButton = (ImageButton)findViewById(R.id.btn_favorite);

        final Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        if (movie != null) {
            String name = movie.getName();
            String description = movie.getDesc();
            String photo = movie.getPhoto();
            tvName.setText(name);
            tvDescription.setText(description);
            Glide.with(this)
                    .load(photo)
                    .into(tvPhoto);

            position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        }


        final long searchlist = movieHelper.searchMovie(movie.getId());
        if (searchlist > 0){
            imageButton.setImageResource(R.drawable.ic_favorite_red_24dp);
        }else {
            imageButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Movie movies = new Movie();
                movies.setId(movie.getId());
                movies.setName(movie.getName());
                movies.setDesc(movie.getDesc());
                movies.setPhoto(movie.getPhoto());

                Intent intent = new Intent();
                intent.putExtra(EXTRA_MOVIE, movie);
                intent.putExtra(EXTRA_POSITION, position);

                if (searchlist >0) {
                    imageButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    long result = movieHelper.deleteMovie(movies.getId());

                    if(result > 0 ){
                        movies.setId((int) result);
                        setResult(RESULT_DELETE, intent);
                    }else {
                        Toast.makeText(DetailMovie.this, "Error",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    imageButton.setImageResource(R.drawable.ic_favorite_red_24dp);
                    long result = movieHelper.insertMovie(movies);

                    if(result > 0 ){
                        movies.setId((int) result);
                        setResult(RESULT_ADD, intent);
                    }else {
                        Toast.makeText(DetailMovie.this, "Error",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }

}
