package com.tarigan.mazmursubs2.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.R;

import java.util.ArrayList;

public class FavoriteMovieAdapter extends RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieHolder> {
    private ArrayList<Movie> listMovie = new ArrayList<>();
    private ListMovieAdapter.OnItemClickCallback onItemClickCallback;
    private Activity activity;



    @NonNull
    @Override
    public FavoriteMovieAdapter.FavoriteMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_movie, parent, false);
        return new FavoriteMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteMovieAdapter.FavoriteMovieHolder holder, int position) {
        Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(55, 56))
                .into(holder.imgPhoto);

        holder.tvName.setText(movie.getName());
        holder.tvDesc.setText(movie.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public void setOnItemClickCallback(ListMovieAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public class FavoriteMovieHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cvMovie;

        public FavoriteMovieHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_movies_photo);
            tvName = itemView.findViewById(R.id.tv_item_movies_name);
            tvDesc = itemView.findViewById(R.id.tv_item_movies_desc);
            cvMovie = itemView.findViewById(R.id.cv_item_movie);
        }
    }

    public FavoriteMovieAdapter(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie){
        if(listMovie.size() > 0){
            this.listMovie.clear();
        }
        this.listMovie.addAll(listMovie);

        notifyDataSetChanged();
    }

    public void addMovie(Movie movie){
        this.listMovie.add(movie);
        notifyItemInserted(listMovie.size() - 1);
    }

    public void updateMovie(int position, Movie movie){
        this.listMovie.set(position, movie);
        notifyItemChanged(position, movie);
    }

    public void removeItem(int position){
        this.listMovie.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listMovie.size());
    }
}
