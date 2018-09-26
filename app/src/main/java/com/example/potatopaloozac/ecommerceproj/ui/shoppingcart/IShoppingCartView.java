package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;

import java.util.ArrayList;

public interface IShoppingCartView {
    void showCart(ArrayList<ShoppingCart> cartList);
}
