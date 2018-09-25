package com.example.potatopaloozac.ecommerceproj.ui.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Login;

public class LoginPresenter implements ILoginPresenter, IDataManager.OnLoginListener {

    private IDataManager dataManager;
    private ILoginView loginView;
    private SharedPreferences sp;
    private Context context;

    public LoginPresenter (LoginActivity activity) {
        dataManager = new DataManager(activity);
        loginView = activity;
        context = activity;
    }

    @Override
    public void onActivityCreated() {
        loginView.showLogin();
    }

    @Override
    public void onLoginButtonClicked(String mobile, String password) {
        sp = context.getSharedPreferences("userlogin", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("mobile", mobile);
        editor.putString("password", password);
        editor.commit();

        dataManager.login(this);
    }

    @Override
    public void userLogin (Login login) {
        loginView.loginSuccessful();
    }
}
