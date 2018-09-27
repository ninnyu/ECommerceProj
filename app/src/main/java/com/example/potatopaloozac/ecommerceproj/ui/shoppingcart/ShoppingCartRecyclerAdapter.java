package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.DbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShoppingCartRecyclerAdapter extends RecyclerView.Adapter<ShoppingCartRecyclerAdapter.MyViewHolder> {

    private List<ShoppingCart> cartList;
    private CartUpdateRemoveClick clickListener;

    public ShoppingCartRecyclerAdapter(List<ShoppingCart> cartList, CartUpdateRemoveClick clickListener) {
        this.cartList = cartList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final ShoppingCart cartObj = cartList.get(position);

        int total = Integer.parseInt(cartObj.getProduct().getPrice());
        total *= cartObj.getQuantity();

        String quantity = Integer.toString(cartObj.getQuantity());
        String totalPrice = Integer.toString(total);

        holder.tv_name.setText((cartObj.getProduct().getPname()));
        holder.et_quantity.setText(quantity);
        holder.tv_price.setText((cartObj.getProduct().getPrice()));
        holder.tv_totalPrice.setText(totalPrice);

        Picasso.get()
                .load((cartObj.getProduct().getImage()))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);

        holder.tv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(holder.et_quantity.getText().toString());
                clickListener.onUpdateItemClick(v, cartObj, n);
            }
        });

        holder.tv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onRemoveItemClick(v, cartObj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_price, tv_totalPrice, tv_update, tv_remove;
        EditText et_quantity;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_cartName);
            et_quantity = itemView.findViewById(R.id.et_cartQuantity);
            tv_price = itemView.findViewById(R.id.tv_cartPrice);
            tv_totalPrice = itemView.findViewById(R.id.tv_cartTotalPrice);
            tv_update = itemView.findViewById(R.id.tv_update);
            tv_remove = itemView.findViewById(R.id.tv_remove);
            iv_image = itemView.findViewById(R.id.iv_cartImage);
        }
    }
}
