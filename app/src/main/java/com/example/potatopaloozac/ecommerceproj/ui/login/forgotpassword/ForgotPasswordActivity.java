package com.example.potatopaloozac.ecommerceproj.ui.login.forgotpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.potatopaloozac.ecommerceproj.R;

public class ForgotPasswordActivity extends AppCompatActivity implements IForgotPasswordView {

    private IForgotPasswordPresenter forgotPasswordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
}
