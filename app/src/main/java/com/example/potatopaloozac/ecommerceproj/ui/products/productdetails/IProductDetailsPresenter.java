package com.example.potatopaloozac.ecommerceproj.ui.products.productdetails;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public interface IProductDetailsPresenter {
    void onActivityCreated();
    void onAddToCartButtonClicked(Product product, int n);
    void onAddToFavoritesButtonClicked(Product product);
}
