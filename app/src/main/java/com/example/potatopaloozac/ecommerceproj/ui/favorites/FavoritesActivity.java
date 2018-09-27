package com.example.potatopaloozac.ecommerceproj.ui.favorites;

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

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartRecyclerAdapter;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FavoritesActivity extends AppCompatActivity implements IFavoritesView {

    @BindView(R.id.rv_favorites)
    RecyclerView rvFavorites;
    @BindView(R.id.bt_toolbarHome)
    Button btToolbarHome;
    @BindView(R.id.bt_toolbarTopsellers)
    Button btToolbarTopsellers;
    @BindView(R.id.bt_toolbarFavorites)
    Button btToolbarFavorites;
    @BindView(R.id.bt_toolbarShoppingcart)
    Button btToolbarShoppingcart;
    @BindView(R.id.bt_toolbarUserProfile)
    Button btToolbarUserProfile;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;

    private IFavoritesPresenter favoritesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ButterKnife.bind(this);

        tvTitlebar.setText(R.string.favorite);

        setSupportActionBar(toolbar);

        favoritesPresenter = new FavoritesPresenter(this);
        favoritesPresenter.onActivityCreated();
    }

    @Override
    public void showFavorites(ArrayList<Favorite> favoriteList) {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rvFavorites.setLayoutManager(manager);
        rvFavorites.setItemAnimator(new DefaultItemAnimator());

        if (favoriteList != null) {
            FavoritesRecyclerAdapter recyclerAdapter = new FavoritesRecyclerAdapter(favoriteList, new CustomClickListener.FavoriteRemoveClick() {
                @Override
                public void onRemoveItemClick(View v, Favorite favorite) {
                    favoritesPresenter.onRemoveButtonClicked(v, favorite);
                }
            });
            rvFavorites.setAdapter(recyclerAdapter);
        }
    }

    @OnClick({R.id.bt_toolbarHome, R.id.bt_toolbarTopsellers, R.id.bt_toolbarShoppingcart, R.id.bt_toolbarUserProfile})
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
            case R.id.bt_toolbarShoppingcart: {
                Intent i = new Intent(this, ShoppingCartActivity.class);
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
