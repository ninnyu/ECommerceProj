package com.example.potatopaloozac.ecommerceproj.utils;

import com.example.potatopaloozac.ecommerceproj.data.network.NetworkHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.model.LoginModule;
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginPresenterModule;

import javax.inject.Singleton;

import dagger.Component;

@Component (modules = {LoginModule.class})
@Singleton
public interface MyComponent {
    void inject(NetworkHelper networkHelper);
}
