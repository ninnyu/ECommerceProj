package com.example.potatopaloozac.ecommerceproj.data.database;

import com.example.potatopaloozac.ecommerceproj.data.IDataManager.*;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public interface IDbHelper {
    //For ShoppingCart
    void createRow(OnCartAddedListener cartAddedListener, Product product, int n);
    void readRow(OnCartListener cartListener);
    void updateRow(OnCartUpdatedListener cartUpdatedListener, ShoppingCart cart, int n);
    void deleteRow(OnCartItemDeletedListener itemDeletedListener, ShoppingCart cart);

    //For Favorite
    void createRow(OnFavoritesAddedListener favoritesAddedListener, Product product);
    void readRow(OnFavoritesListener favoritesListener);
    void deleteRow(OnFavoritesDeletedListener favoritesDeletedListener, Favorite favorite);
    boolean isFavorite(OnFavoritesListener favoritesListener, Product product);
}
