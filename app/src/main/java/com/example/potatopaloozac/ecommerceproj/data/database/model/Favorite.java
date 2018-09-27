package com.example.potatopaloozac.ecommerceproj.data.database.model;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public class Favorite {
    Product product;

    public Favorite(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
