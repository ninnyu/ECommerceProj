package com.example.potatopaloozac.ecommerceproj.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.potatopaloozac.ecommerceproj.data.database.DbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.IDbHelper;
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
    public void createRow(Product product, int n, int inCart, int inFavorites) {
        dbHelper.createRow(product, n, inCart, inFavorites);
    }

    @Override
    public void readRow(Product product) {
        dbHelper.readRow(product);
    }

    @Override
    public void updateRow(Product product, int n, int inCart, int inFavorites) {
        dbHelper.updateRow(product, n, inCart, inFavorites);
    }

    @Override
    public void deleteRow(Product product) {
        dbHelper.deleteRow(product);
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
        Product product = new Product(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
        return product;
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
