package com.example.potatopaloozac.ecommerceproj.ui.products.productdetails;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public interface IProductDetailsView {
    void showProductDetails(Product product);
    void showToast(String s);
}
