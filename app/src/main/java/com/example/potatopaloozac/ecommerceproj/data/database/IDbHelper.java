package com.example.potatopaloozac.ecommerceproj.data.database;

import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public interface IDbHelper {

    void createRow(Product product, int n, int inCart, int inFavorites);
    void readRow(Product product);
    void updateRow(Product product, int n, int inCart, int inFavorites);
    void deleteRow(Product product);
}
