package com.example.potatopaloozac.ecommerceproj.data;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.potatopaloozac.ecommerceproj.data.database.DbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.IDbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.network.INetworkHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.NetworkHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public class DataManager implements IDataManager {

    private IDbHelper dbHelper;
    private INetworkHelper networkHelper;

    public DataManager(Context context) {
        dbHelper = new DbHelper(context);
        networkHelper = new NetworkHelper(context);
    }

    @Override
    public void createRow(OnCartAddedListener cartAddedListener, Product product, int n) {
        dbHelper.createRow(cartAddedListener, product, n);
    }

    @Override
    public void readRow(OnCartListener cartListener) {
        dbHelper.readRow(cartListener);
    }

    @Override
    public void updateRow(OnCartUpdatedListener cartUpdatedListener, ShoppingCart cart, int n) {
        dbHelper.updateRow(cartUpdatedListener, cart, n);
    }

    @Override
    public void deleteRow(OnCartItemDeletedListener itemDeletedListener, ShoppingCart cart) {
        dbHelper.deleteRow(itemDeletedListener, cart);
    }

    @Override
    public void createRow(OnFavoritesAddedListener favoritesAddedListener, Product product) {
        dbHelper.createRow(favoritesAddedListener, product);
    }

    @Override
    public void readRow(OnFavoritesListener favoritesListener) {
        dbHelper.readRow(favoritesListener);
    }

    @Override
    public void deleteRow(OnFavoritesDeletedListener favoritesDeletedListener, Favorite favorite) {
        dbHelper.deleteRow(favoritesDeletedListener, favorite);
    }

    @Override
    public boolean isFavorite(OnFavoritesListener favoritesListener, Product product) {
        return dbHelper.isFavorite(favoritesListener, product);
    }

    @Override
    public void getCategoryList(OnCategoryListener categoryListener) {
        networkHelper.getCategoryList(categoryListener);
    }

    @Override
    public void getSubCategoryList(OnSubCategoryListener subCategoryListener, Activity activity) {
        networkHelper.getSubCategoryList(subCategoryListener, activity);
    }

    @Override
    public void getProductList(OnProductListener productListener, Activity activity) {
        networkHelper.getProductList(productListener, activity);
    }

    @Override
    public Product getDetails(Activity activity) {
        Bundle b = activity.getIntent().getExtras();
        String[] arr = b.getStringArray("productdetails");
        return new Product(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
    }

    @Override
    public void login(OnLoginListener loginListener) {
        networkHelper.login(loginListener);
    }

    @Override
    public void getUserProfile(OnUserProfileListener profileListener) {
        networkHelper.getUserProfile(profileListener);
    }

    @Override
    public void updateProfile(OnProfileUpdateListener profileUpdateListener, UserProfile profile) {
        networkHelper.updateProfile(profileUpdateListener, profile);
    }

    @Override
    public void register(OnRegisterListener registerListener, UserProfile profile) {
        networkHelper.register(registerListener, profile);
    }

    @Override
    public void getSellerList(OnTopSellerListener sellerListener) {
        networkHelper.getSellerList(sellerListener);
    }

}
