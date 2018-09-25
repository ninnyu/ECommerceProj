package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductRecyclerAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product productObj = productList.get(position);

        holder.tv_cid.setText(productObj.getId());
        holder.tv_cname.setText(productObj.getPname());
        holder.tv_cdescriptioe.setText(productObj.getDescription());

        Picasso.get()
                .load(productObj.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_cid, tv_cname, tv_cdescriptioe;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_cid = itemView.findViewById(R.id.tv_cid);
            tv_cname = itemView.findViewById(R.id.tv_cname);
            tv_cdescriptioe = itemView.findViewById(R.id.tv_cdescription);
            iv_image = itemView.findViewById(R.id.iv_cimage);
        }
    }
}