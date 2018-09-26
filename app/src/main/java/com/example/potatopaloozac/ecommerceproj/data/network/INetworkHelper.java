package com.example.potatopaloozac.ecommerceproj.data.network;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public interface INetworkHelper {
    void getCategoryList(IDataManager.OnCategoryListener categoryListener);
    void getSubCategoryList(IDataManager.OnSubCategoryListener subCategoryListener, Activity activity);
    void getProductList(IDataManager.OnProductListener productListener, Activity activity);
    void login(IDataManager.OnLoginListener loginListener);
    void getUserProfile(IDataManager.OnUserProfileListener profileListener);
    void updateProfile(IDataManager.OnProfileUpdateListener profileUpdateListener, UserProfile profile);
    void register(IDataManager.OnRegisterListener registerListener, UserProfile profile);
    void getSellerList(IDataManager.OnTopSellerListener sellerListener);
}
