package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.DbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShoppingCartRecyclerAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerAdapter.MyViewHolder> {

    private List<ShoppingCart> cartList;
    DbHelper dbHelper;
    private Context context;

    public ShoppingCartRecyclerAdapter(List<ShoppingCart> cartList, Context context) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ShoppingCart cartObj = cartList.get(position);

        holder.tv_cname.setText((cartObj.getProduct().getPname()));
        holder.tv_cdescription.setText((cartObj.getProduct().getDescription()));

        Picasso.get()
                .load((cartObj.getProduct().getImage()))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subCategoryClickListener.onItemClick(v, cartObj);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return cartList.size();
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