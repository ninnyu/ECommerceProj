package com.example.potatopaloozac.ecommerceproj.ui.login.userprofile;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public class UserProfilePresenter implements IUserProfilePresenter, IDataManager.OnUserProfileListener {

    private IDataManager dataManager;
    private IUserProfileView profileView;

    public UserProfilePresenter(UserProfileActivity activity) {
        dataManager = new DataManager(activity);
        profileView = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.getUserProfile(this);
    }

    @Override
    public void userProfile(UserProfile profile) {
        profileView.showUser(profile);
    }
}
