package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {

    private List<Product> productList;
    private ProductClick productClickListener;

    public ProductRecyclerAdapter(List<Product> productList, ProductClick productClickListener) {
        this.productList = productList;
        this.productClickListener = productClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Product productObj = productList.get(position);

        Picasso.get()
                .load(productObj.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productClickListener.onItemClick(v, productObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv_image = itemView.findViewById(R.id.iv_pimage);
        }
    }
}