package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

public interface IProductView {
    void showProductList(ArrayList<Product> productList);
}
