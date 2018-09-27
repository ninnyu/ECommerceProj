package com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;
import com.example.potatopaloozac.ecommerceproj.ui.favorites.FavoritesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.SubCategoryClick;
import com.example.potatopaloozac.ecommerceproj.ui.products.productlist.ProductsActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubCategoriesActivity extends AppCompatActivity implements ISubCategoryView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tv_titlebar;

    private RecyclerView rv_subcategories;
    private ISubCategoryPresenter subCategoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);
        ButterKnife.bind(this);

        rv_subcategories = findViewById(R.id.rv_subcategories);

        tv_titlebar.setText(R.string.subcategory);

        setSupportActionBar(toolbar);

        subCategoryPresenter = new SubCategoryPresenter(this);
        subCategoryPresenter.onActivityCreated();
    }


    @Override
    public void showSubCategoriesList(ArrayList<ProductSubCategory> subCategoryList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_subcategories.setLayoutManager(manager);
        rv_subcategories.setItemAnimator(new DefaultItemAnimator());

        if (subCategoryList != null) {
            SubCategoryRecyclerAdapter recyclerAdapter = new SubCategoryRecyclerAdapter(subCategoryList, new SubCategoryClick() {
                @Override
                public void onItemClick(View v, ProductSubCategory subCategory) {
                    Bundle b = new Bundle();
                    b.putString("scid", subCategory.getScid());

                    Intent i = new Intent(SubCategoriesActivity.this, ProductsActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            });
            rv_subcategories.setAdapter(recyclerAdapter);
        }
    }

    @OnClick({R.id.bt_toolbarHome, R.id.bt_toolbarTopsellers, R.id.bt_toolbarFavorites, R.id.bt_toolbarShoppingcart, R.id.bt_toolbarUserProfile})
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
