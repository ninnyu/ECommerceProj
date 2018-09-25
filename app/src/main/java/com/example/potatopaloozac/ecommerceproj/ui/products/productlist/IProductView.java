package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

public interface IProductView {
    public void showProductList(ArrayList<Product> productList);
}
