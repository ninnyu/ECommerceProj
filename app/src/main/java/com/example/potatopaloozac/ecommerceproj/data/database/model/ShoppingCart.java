package com.example.potatopaloozac.ecommerceproj.data.database.model;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public class ShoppingCart {

    private Product product;
    private int quantity;

    public ShoppingCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
