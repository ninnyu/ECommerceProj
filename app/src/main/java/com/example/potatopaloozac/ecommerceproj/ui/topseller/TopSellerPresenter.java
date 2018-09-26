package com.example.potatopaloozac.ecommerceproj.ui.topseller;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.TopSeller;

import java.util.ArrayList;

public class TopSellerPresenter implements ITopSellerPresenter, IDataManager.OnTopSellerListener {

    ITopSellerView sellerView;
    IDataManager dataManager;
    Activity activity;

    public TopSellerPresenter(TopSellerActivity activity) {
        dataManager = new DataManager(activity);
        sellerView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.getSellerList(this);
    }

    @Override
    public void getTopSellers(ArrayList<TopSeller> sellerList) {
        sellerView.showSellers(sellerList);
    }
}
