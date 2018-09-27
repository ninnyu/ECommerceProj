package com.example.potatopaloozac.ecommerceproj.ui.products.productdetails;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.ui.favorites.FavoritesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.login.userprofile.UserProfileActivity;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;
import com.example.potatopaloozac.ecommerceproj.ui.shoppingcart.ShoppingCartActivity;
import com.example.potatopaloozac.ecommerceproj.ui.topseller.TopSellerActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsActivity extends AppCompatActivity implements IProductDetailsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_titlebar)
    TextView tv_titlebar;
    @BindView(R.id.iv_product)
    ImageView iv_product;
    @BindView(R.id.tv_detailsName)
    TextView tv_detailsName;
    @BindView(R.id.tv_detailsQuantity)
    TextView tv_detailsQuantity;
    @BindView(R.id.tv_detailsPrice)
    TextView tv_detailsPrice;
    @BindView(R.id.tv_detailsDesc)
    TextView tv_detailsDesc;
    @BindView(R.id.et_quantity)
    TextView et_quantity;

    private IProductDetailsPresenter detailsPresenter;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        tv_titlebar.setText(R.string.shop);

        detailsPresenter = new ProductDetailsPresenter(this);
        detailsPresenter.onActivityCreated();
    }


    @Override
    public void showProductDetails(Product product) {
        this.product = product;

        tv_detailsName.setText(product.getPname());
        tv_detailsQuantity.setText(product.getQuantityInStock());
        tv_detailsPrice.setText(product.getPrice());
        tv_detailsDesc.setText(product.getDescription());

        Picasso.get()
                .load(product.getImage())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(this.iv_product);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.bt_toolbarHome, R.id.bt_toolbarTopsellers, R.id.bt_toolbarFavorites, R.id.bt_toolbarShoppingcart, R.id.bt_toolbarUserProfile, R.id.bt_favorite, R.id.bt_cart})
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
            case R.id.bt_favorite: {
                detailsPresenter.onAddToFavoritesButtonClicked(product);
                break;
            }
            case R.id.bt_cart: {
                detailsPresenter.onAddToCartButtonClicked(product, Integer.parseInt(et_quantity.getText().toString()));
                break;
            }
        }
    }
}
