package com.tarigan.mazmursubs2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tarigan.mazmursubs2.Model.Movie;
import com.tarigan.mazmursubs2.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public ListMovieAdapter() {
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<Movie> items){
        listMovie.clear();
        listMovie.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(final Movie item){
        listMovie.add(item);
        notifyDataSetChanged();
    }

    public void clearData(){
        listMovie.clear();
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_movies, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(55, 56))
                .into(holder.imgPhoto);

        holder.tvName.setText(movie.getName());
        holder.tvDesc.setText(movie.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }



    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_movies_photo);
            tvName = itemView.findViewById(R.id.tv_item_movies_name);
            tvDesc = itemView.findViewById(R.id.tv_item_movies_desc);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie data);
    }
}
