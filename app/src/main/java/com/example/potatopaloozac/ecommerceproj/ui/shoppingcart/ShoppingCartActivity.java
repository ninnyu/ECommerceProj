package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.potatopaloozac.ecommerceproj.R;

public class ShoppingCartActivity extends AppCompatActivity implements IShoppingCartView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }
}
