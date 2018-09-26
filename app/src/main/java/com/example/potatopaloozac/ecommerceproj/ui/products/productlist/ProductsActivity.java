package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productdetails.ProductDetailsActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;
import com.example.potatopaloozac.ecommerceproj.utils.CustomClickListener.*;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsActivity extends AppCompatActivity implements IProductView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tv_titlebar;

    private RecyclerView rv_products;
    private IProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        rv_products = findViewById(R.id.rv_products);

        tv_titlebar.setText(R.string.shop);

        setSupportActionBar(toolbar);

        productPresenter = new ProductPresenter(this);
        productPresenter.onActivityCreated();
    }

    @Override
    public void showProductList(ArrayList<Product> productList) {

        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);

        rv_products.setLayoutManager(manager);
        rv_products.setItemAnimator(new DefaultItemAnimator());

        if (productList != null) {
            ProductRecyclerAdapter recyclerAdapter = new ProductRecyclerAdapter(productList, this, new ProductClick() {
                @Override
                public void onItemClick(View v, Product product) {
                    String[] details = {product.getId(), product.getPname(), product.getQuantity(),
                            product.getPrice(), product.getDescription(), product.getImage()};

                    Bundle b = new Bundle();
                    b.putStringArray("productdetails", details);

                    Intent i = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            });
            rv_products.setAdapter(recyclerAdapter);
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
                Toast.makeText(this, "clicked favorites", Toast.LENGTH_SHORT).show();
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
