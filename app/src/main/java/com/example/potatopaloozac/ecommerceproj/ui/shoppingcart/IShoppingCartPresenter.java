package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;

import java.util.ArrayList;

public interface IShoppingCartPresenter {
    void onActivityCreated();
    void onUpdateButtonClicked(View v, ShoppingCart cart, int n);
    void onRemoveButtonClicked(View v, ShoppingCart cart);
}
