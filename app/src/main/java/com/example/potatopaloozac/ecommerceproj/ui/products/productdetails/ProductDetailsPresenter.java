package com.example.potatopaloozac.ecommerceproj.ui.products.productdetails;

import android.app.Activity;
import android.os.Bundle;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

public class ProductDetailsPresenter implements IProductDetailsPresenter {

    private IDataManager dataManager;
    private IProductDetailsView productView;
    Activity activity;

    public ProductDetailsPresenter(ProductDetailsActivity activity) {
        dataManager = new DataManager(activity);
        productView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        Product product = dataManager.getDetails(activity);
        productView.showProductDetails(product);
    }
}
