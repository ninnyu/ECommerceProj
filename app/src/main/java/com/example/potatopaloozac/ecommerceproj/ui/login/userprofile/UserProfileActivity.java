package com.example.potatopaloozac.ecommerceproj.ui.login.userprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.updateprofile.UpdateProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProfileActivity extends AppCompatActivity implements IUserProfileView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;
    @BindView(R.id.tv_userid)
    TextView tvUserid;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_useraddress)
    TextView tvUseraddress;
    @BindView(R.id.tv_useremail)
    TextView tvUseremail;
    @BindView(R.id.tv_usermobile)
    TextView tvUsermobile;

    private IUserProfilePresenter profilePresenter;
    public static Activity userProfileActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);

        userProfileActivity = this;

        setSupportActionBar(toolbar);

        tvTitlebar.setText(R.string.userprofile);

        profilePresenter = new UserProfilePresenter(this);
        profilePresenter.onActivityCreated();
    }

    @Override
    public void showUser(UserProfile profile) {
        String username = profile.getFname() + " " + profile.getLname();
        tvUserid.setText(profile.getId());
        tvUserName.setText(username);
        tvUseraddress.setText(profile.getAddress());
        tvUseremail.setText(profile.getEmail());
        tvUsermobile.setText(profile.getMobile());
    }

    @OnClick({R.id.bt_toolbarHome, R.id.bt_toolbarTopsellers, R.id.bt_toolbarFavorites, R.id.bt_toolbarShoppingcart, R.id.bt_updateProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_toolbarHome: {
                Intent i = new Intent(this, CategoriesActivity.class);
                startActivity(i);
                break;
            }
            case R.id.bt_toolbarTopsellers: {
                Intent i = new Intent(this, TopSellerActivity.class);
                startActivity(i);
                break;
            }
            case R.id.bt_toolbarFavorites: {
                Toast.makeText(this, "clicked favorites", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.bt_toolbarShoppingcart: {
                Intent i = new Intent(this, ShoppingCartActivity.class);
                startActivity(i);
                break;
            }
            case R.id.bt_updateProfile: {
                Intent i = new Intent(this, UpdateProfileActivity.class);
                startActivity(i);
                break;
            }
        }
    }
}
