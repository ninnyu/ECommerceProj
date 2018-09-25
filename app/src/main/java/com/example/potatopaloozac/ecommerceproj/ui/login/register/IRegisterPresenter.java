package com.example.potatopaloozac.ecommerceproj.ui.login.register;

import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

public interface IRegisterPresenter {
    public void onActivityCreated();
    public void onRegisterButtonClicked(UserProfile profile);
}
