package com.example.potatopaloozac.ecommerceproj.ui.topseller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.TopSeller;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopSellerRecyclerAdapter extends RecyclerView.Adapter<TopSellerRecyclerAdapter.MyViewHolder>  {

    private List<TopSeller> sellerList;

    public TopSellerRecyclerAdapter(List<TopSeller> sellerList) {
        this.sellerList = sellerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.topseller_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TopSeller sellerObj = sellerList.get(position);

        holder.tv_name.setText(sellerObj.getName());
        holder.tv_deal.setText(sellerObj.getDeal());
        holder.tv_rating.setText(sellerObj.getRating());

        Picasso.get()
                .load(sellerObj.getLogo())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_deal, tv_rating;
        ImageView iv_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_sellername);
            tv_deal = itemView.findViewById(R.id.tv_sellerdeal);
            tv_rating = itemView.findViewById(R.id.tv_sellerrating);
            iv_image = itemView.findViewById(R.id.iv_sellerimage);
        }
    }
}
