package com.example.potatopaloozac.ecommerceproj.ui.order;

import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;

import java.util.ArrayList;

public interface IOrderView {
    void showOrder(ArrayList<ShoppingCart> cartList);
}
