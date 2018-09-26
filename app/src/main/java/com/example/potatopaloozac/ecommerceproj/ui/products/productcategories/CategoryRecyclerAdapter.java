package com.example.potatopaloozac.ecommerceproj.ui.products.productcategories;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.MyViewHolder> {

    private List<ProductCategory> categoryList;
    private CategoryClick clickListener;

    public CategoryRecyclerAdapter(List<ProductCategory> categoryList, Context context, CategoryClick clickListener) {
        this.categoryList = categoryList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ProductCategory categoryObj = categoryList.get(position);

        holder.tv_cname.setText(categoryObj.getCname());
        holder.tv_cdescription.setText(categoryObj.getCdescription());

        Picasso.get()
                .load(categoryObj.getCimageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, categoryObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_cname, tv_cdescription;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_cname = itemView.findViewById(R.id.tv_cname);
            tv_cdescription = itemView.findViewById(R.id.tv_cdescription);
            iv_image = itemView.findViewById(R.id.iv_cimage);
        }
    }
}