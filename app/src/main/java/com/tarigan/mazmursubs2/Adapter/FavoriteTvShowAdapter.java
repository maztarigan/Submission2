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
import com.tarigan.mazmursubs2.Model.TvShow;
import com.tarigan.mazmursubs2.R;

import java.util.ArrayList;

public class FavoriteTvShowAdapter extends RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvShowHolder> {
    private ArrayList<TvShow> listTvShow = new ArrayList<>();
    private ListTvShowAdapter.OnItemClickCallback onItemClickCallback;
    private Activity activity;

    @NonNull
    @Override
    public FavoriteTvShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite_tvshow, parent, false);
        return new FavoriteTvShowAdapter.FavoriteTvShowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteTvShowHolder holder, int position) {
        TvShow tvShow = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(55, 56))
                .into(holder.imgPhoto);

        holder.tvName.setText(tvShow.getName());
        holder.tvDesc.setText(tvShow.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listTvShow.get(holder.getAdapterPosition()));
            }
        });
    }

    public void setOnItemClickCallback(ListTvShowAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class FavoriteTvShowHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cvTvShow;

        public FavoriteTvShowHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_tvshow_photo);
            tvName = itemView.findViewById(R.id.tv_item_tvshow_name);
            tvDesc = itemView.findViewById(R.id.tv_item_tvshow_desc);
            cvTvShow = itemView.findViewById(R.id.cv_item_tvshow);
        }
    }

    public FavoriteTvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<TvShow> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<TvShow> listTvShow){
        if(listTvShow.size() > 0){
            this.listTvShow.clear();
        }
        this.listTvShow.addAll(listTvShow);

        notifyDataSetChanged();
    }

    public void addTvShow(TvShow tvShow){
        this.listTvShow.add(tvShow);
        notifyItemInserted(listTvShow.size() - 1);
    }

    public void updateTvShow(int position, TvShow tvShow){
        this.listTvShow.set(position, tvShow);
        notifyItemChanged(position, tvShow);
    }

    public void removeItem(int position){
        this.listTvShow.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listTvShow.size());
    }
}
