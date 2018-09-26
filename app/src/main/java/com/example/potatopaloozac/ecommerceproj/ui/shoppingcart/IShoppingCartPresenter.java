package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.view.View;

public interface IShoppingCartPresenter {
    void onActivityCreated();
    void getCartData();
    void onButtonClicked(View v);
}
