package com.example.potatopaloozac.ecommerceproj.ui.login.register;

import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public interface IRegisterPresenter {
    void onActivityCreated();
    void onRegisterButtonClicked(UserProfile profile);
}
