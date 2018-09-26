package com.example.potatopaloozac.ecommerceproj.ui.topseller;

import com.example.potatopaloozac.ecommerceproj.data.network.model.TopSeller;

import java.util.ArrayList;

public interface ITopSellerView {
    void showSellers(ArrayList<TopSeller> sellerList);
}
