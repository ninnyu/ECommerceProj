package com.example.potatopaloozac.ecommerceproj.data.database.model;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public class ShoppingCart {

    private Product product;
    private int quantity, inCart, inFavorites;

    public ShoppingCart(Product product, int quantity, int inCart, int inFavorites) {
        this.product = product;
        this.quantity = quantity;
        this.inCart = inCart;
        this.inFavorites = inFavorites;
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

    public int getInCart() {
        return inCart;
    }

    public void setInCart(int inCart) {
        this.inCart = inCart;
    }

    public int getInFavorites() {
        return inFavorites;
    }

    public void setInFavorites(int inFavorites) {
        this.inFavorites = inFavorites;
    }
}
