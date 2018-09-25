package com.example.potatopaloozac.ecommerceproj.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.ui.login.forgotpassword.ForgotPasswordActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.register.RegisterActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText et_mobile, et_password;
    private TextView tv_register, tv_forgotpassword;
    private Button bt_login;
    private ILoginPresenter loginPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_mobile = findViewById(R.id.et_loginmobile);
        et_password = findViewById(R.id.et_loginpassword);

        tv_register = findViewById(R.id.tv_register);
        tv_forgotpassword = findViewById(R.id.tv_forgotpassword);

        bt_login = findViewById(R.id.bt_login);

        loginPresenter = new LoginPresenter(this);
        loginPresenter.onActivityCreated();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLoginButtonClicked(et_mobile.getText().toString(), et_password.getText().toString());
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        tv_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void showLogin() {
        sp = getSharedPreferences("userlogin", MODE_PRIVATE);

        String m = sp.getString("mobile", "");
        String p = sp.getString("password", "");

        et_mobile.setText(m);
        et_password.setText(p);
    }

    @Override
    public void loginSuccessful() {
        Intent i = new Intent(this, CategoriesActivity.class);
        startActivity(i);
    }
}
