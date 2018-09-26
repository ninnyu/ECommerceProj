package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.database.DbHelper;

public class ShoppingCartPresenter implements IShoppingCartPresenter {

    IShoppingCartView cartView;
    IDataManager dataManager;
    Activity activity;

    public ShoppingCartPresenter(ShoppingCartActivity activity) {
        dataManager = new DataManager(activity);
        this.cartView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        //dataManager.
    }

    @Override
    public void getCartData() {

    }

    @Override
    public void onButtonClicked(View v) {

    }
}
