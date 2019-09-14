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
import com.tarigan.mazmursubs2.R;
import com.tarigan.mazmursubs2.Model.TvShow;

import java.util.ArrayList;

public class ListTvShowAdapter extends RecyclerView.Adapter<ListTvShowAdapter.ListViewHolder> {
    private ArrayList<TvShow> listTvShow;
    private ListTvShowAdapter.OnItemClickCallback onItemClickCallback;

    public ListTvShowAdapter() {

    }

    public void setOnItemClickCallback(ListTvShowAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<TvShow> items){
        listTvShow.clear();
        listTvShow.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(final TvShow item){
        listTvShow.add(item);
        notifyDataSetChanged();
    }

    public void clearData(){
        listTvShow.clear();
    }

    @NonNull
    @Override
    public ListTvShowAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_tvshow, viewGroup, false);
        return new ListTvShowAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListTvShowAdapter.ListViewHolder holder, int position) {
        TvShow tvShow = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(55, 56))
                .into(holder.imgPhoto);

        holder.tvName.setText(tvShow.getName());
        holder.tvDesc.setText(tvShow.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listTvShow.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_tvshow_photo);
            tvName = itemView.findViewById(R.id.tv_item_tvshow_name);
            tvDesc = itemView.findViewById(R.id.tv_item_tvshow_desc);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow data);
    }
}
