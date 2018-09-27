package com.example.potatopaloozac.ecommerceproj.ui.products.productcategories;

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
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.ui.favorites.FavoritesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.CategoryClick;
import com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories.SubCategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoriesActivity extends AppCompatActivity implements ICategoryView {

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

    private RecyclerView rv_categories;
    private ICategoryPresenter categoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        rv_categories = findViewById(R.id.rv_categories);

        tv_titlebar.setText(R.string.category);

        setSupportActionBar(toolbar);

        categoryPresenter = new CategoryPresenter(this);
        categoryPresenter.onActivityCreated();
    }

    @Override
    public void showCategoriesList(ArrayList<ProductCategory> categoryList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_categories.setLayoutManager(manager);
        rv_categories.setItemAnimator(new DefaultItemAnimator());

        if (categoryList != null) {
            CategoryRecyclerAdapter recyclerAdapter = new CategoryRecyclerAdapter(categoryList, new CategoryClick() {
                @Override
                public void onItemClick(View v, ProductCategory category) {
                    Bundle b = new Bundle();
                    b.putString("cid", category.getCid());

                    Intent i = new Intent(CategoriesActivity.this, SubCategoriesActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            });
            rv_categories.setAdapter(recyclerAdapter);
        }
    }

    @OnClick({R.id.bt_toolbarTopsellers, R.id.bt_toolbarFavorites, R.id.bt_toolbarShoppingcart, R.id.bt_toolbarUserProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
