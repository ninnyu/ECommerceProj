package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.ui.favorites.FavoritesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingCartActivity extends AppCompatActivity implements IShoppingCartView {

    @BindView(R.id.bt_toolbarHome)
    Button bt_toolbarHome;
    @BindView(R.id.bt_toolbarTopsellers)
    Button bt_toolbarTopsellers;
    @BindView(R.id.bt_toolbarFavorites)
    Button bt_toolbarFavorites;
    @BindView(R.id.bt_toolbarShoppingcart)
    Button bt_toolbarShoppingcart;
    @BindView(R.id.bt_toolbarUserProfile)
    Button bt_toolbarUserProfile;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tv_titlebar;

    private RecyclerView rv_cart;
    private IShoppingCartPresenter cartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ButterKnife.bind(this);

        rv_cart = findViewById(R.id.rv_cart);

        tv_titlebar.setText(R.string.shoppingcart);

        setSupportActionBar(toolbar);

        cartPresenter = new ShoppingCartPresenter(this);
        cartPresenter.onActivityCreated();
    }

    @Override
    public void showCart(ArrayList<ShoppingCart> cartList) {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_cart.setLayoutManager(manager);
        rv_cart.setItemAnimator(new DefaultItemAnimator());

        if (cartList != null) {
            ShoppingCartRecyclerAdapter recyclerAdapter = new ShoppingCartRecyclerAdapter(cartList, new CartUpdateRemoveClick() {
                @Override
                public void onUpdateItemClick(View v, ShoppingCart cart, int n) {
                    cartPresenter.onUpdateButtonClicked(v, cart, n);
                }

                @Override
                public void onRemoveItemClick(View v, ShoppingCart cart) {
                    cartPresenter.onRemoveButtonClicked(v, cart);
                }
            });
            rv_cart.setAdapter(recyclerAdapter);
        }
    }

    @OnClick({R.id.bt_toolbarHome, R.id.bt_toolbarTopsellers, R.id.bt_toolbarFavorites, R.id.bt_toolbarUserProfile})
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
                Intent i = new Intent(this, FavoritesActivity.class);
                startActivity(i);
                break;
            }
            case R.id.bt_toolbarUserProfile: {
                Intent i = new Intent(this, UserProfileActivity.class);
                startActivity(i);
                break;
            }
        }
    }
}
