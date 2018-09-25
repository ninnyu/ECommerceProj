package com.example.potatopaloozac.ecommerceproj.ui.login;

import android.content.Context;

public interface ILoginPresenter {
    public void onActivityCreated();
    public void onLoginButtonClicked(String mobile, String password);
}
