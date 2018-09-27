package com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubCategoryRecyclerAdapter extends RecyclerView.Adapter<SubCategoryRecyclerAdapter.MyViewHolder> {

    private List<ProductSubCategory> subCategoryList;
    private SubCategoryClick subCategoryClickListener;

    public SubCategoryRecyclerAdapter(List<ProductSubCategory> subCategoryList, SubCategoryClick subCategoryClickListener) {
        this.subCategoryList = subCategoryList;
        this.subCategoryClickListener = subCategoryClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ProductSubCategory subCategoryObj = subCategoryList.get(position);

        holder.tv_cname.setText(subCategoryObj.getScname());

        Picasso.get()
                .load(subCategoryObj.getScimageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subCategoryClickListener.onItemClick(v, subCategoryObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subCategoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_cname;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_cname = itemView.findViewById(R.id.tv_cname);
            iv_image = itemView.findViewById(R.id.iv_cimage);
        }
    }
}