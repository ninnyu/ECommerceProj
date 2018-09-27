package com.example.potatopaloozac.ecommerceproj.data.network.model;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private Context context;

    public LoginModule() {

    }

    public LoginModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context getContext() {
        return context;
    }

    @Provides
    public Login getLogin() {
        return new Login();
    }
}
