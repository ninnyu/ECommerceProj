package com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.updateprofile;

import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public interface IUpdateProfilePresenter {
    void onActivityCreated();
    void onUpdateButtonClicked(UserProfile profile);
}
