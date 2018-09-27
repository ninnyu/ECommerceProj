package com.example.potatopaloozac.ecommerceproj.ui.login;

import android.content.Context;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Login;

public class LoginPresenterModule {
    private LoginActivity activity;

    public LoginPresenterModule() {

    }

    public LoginPresenterModule(LoginActivity context) {
        this.activity = context;
    }

    public ILoginPresenter getLoginPresenter() {
        return new LoginPresenter(activity);
    }
}
