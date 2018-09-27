package com.example.potatopaloozac.ecommerceproj.ui.order;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderReclyclerAdapter extends RecyclerView.Adapter<OrderReclyclerAdapter.MyViewHolder>{

    private List<ShoppingCart> cartList;
    private Activity activity;

    public OrderReclyclerAdapter(Activity activity, List<ShoppingCart> cartList) {
        this.activity = activity;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout, parent, false);
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
        holder.tv_quantity.setText(quantity);
        holder.tv_price.setText((cartObj.getProduct().getPrice()));
        holder.tv_totalItemPrice.setText(totalPrice);

        Picasso.get()
                .load((cartObj.getProduct().getImage()))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_price, tv_quantity, tv_totalItemPrice;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_orderName);
            tv_quantity = itemView.findViewById(R.id.tv_orderQuantity);
            tv_price = itemView.findViewById(R.id.tv_orderPrice);
            tv_totalItemPrice = itemView.findViewById(R.id.tv_orderItemTotalPrice);
            iv_image = itemView.findViewById(R.id.iv_orderImage);
        }
    }
}
