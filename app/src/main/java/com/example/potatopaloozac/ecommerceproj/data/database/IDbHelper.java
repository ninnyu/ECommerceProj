package com.example.potatopaloozac.ecommerceproj.data.database;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public interface IDbHelper {

    public void createRow(Product product, int n);
    public void readRow();
    public void updateRow();
    public void deleteRow(Product product);
}
