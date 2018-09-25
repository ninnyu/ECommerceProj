package com.example.potatopaloozac.ecommerceproj.data;

import android.app.Activity;
import android.content.Context;

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
    public void createRow(Product product, int n) {
        dbHelper.createRow(product, n);
    }

    @Override
    public void readRow() {

    }

    @Override
    public void updateRow() {

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
    public void login(OnLoginListener loginListener) {
        networkHelper.login(loginListener);
    }

    @Override
    public void register(OnRegisterListener registerListener, UserProfile profile) {
        networkHelper.register(registerListener, profile);
    }


}
