package com.example.potatopaloozac.ecommerceproj.data.network.model;

public class Product {

    private String id, pname, quantityInStock, price, description, image;

    public Product(String id, String pname, String price, String description, String image) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Product(String id, String pname, String quantityInStock, String price, String description, String image) {
        this.id = id;
        this.pname = pname;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
