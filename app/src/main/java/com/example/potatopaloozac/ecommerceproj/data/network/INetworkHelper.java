package com.example.potatopaloozac.ecommerceproj.data.network;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public interface INetworkHelper {
    public void getCategoryList(IDataManager.OnCategoryListener categoryListener);
    public void getSubCategoryList(IDataManager.OnSubCategoryListener subCategoryListener, Activity activity);
    public void getProductList(IDataManager.OnProductListener productListener, Activity activity);
    public void login(IDataManager.OnLoginListener loginListener);
    public void register(IDataManager.OnRegisterListener registerListener, UserProfile profile);
}
