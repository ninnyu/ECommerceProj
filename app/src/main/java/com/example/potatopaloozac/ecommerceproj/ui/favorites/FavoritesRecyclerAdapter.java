package com.example.potatopaloozac.ecommerceproj.ui.favorites;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<FavoritesRecyclerAdapter.MyViewHolder>  {

    private List<Favorite> favoriteList;
    private FavoriteRemoveClick clickListener;

    public FavoritesRecyclerAdapter(List<Favorite> favoriteList, FavoriteRemoveClick clickListener) {
        this.favoriteList = favoriteList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Favorite favoriteObj = favoriteList.get(position);

        holder.tv_name.setText(favoriteObj.getProduct().getPname());
        holder.tv_inStock.setText(favoriteObj.getProduct().getQuantityInStock());
        holder.tv_price.setText(favoriteObj.getProduct().getPrice());

        Picasso.get()
                .load((favoriteObj.getProduct().getImage()))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        holder.tv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onRemoveItemClick(v, favoriteObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_inStock, tv_price, tv_remove;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_favoriteName);
            tv_inStock = itemView.findViewById(R.id.tv_favoriteInStock);
            tv_price = itemView.findViewById(R.id.tv_favoritePrice);
            iv_image = itemView.findViewById(R.id.iv_favoriteImage);
            tv_remove = itemView.findViewById(R.id.tv_favoriteRemove);
        }
    }
}
