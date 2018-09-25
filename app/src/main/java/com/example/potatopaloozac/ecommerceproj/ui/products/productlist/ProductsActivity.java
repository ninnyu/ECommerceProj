package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity implements IProductView {

    private RecyclerView rv_products;
    private IProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        rv_products = findViewById(R.id.rv_products);

        productPresenter = new ProductPresenter(this);
        productPresenter.onActivityCreated();
    }

    @Override
    public void showProductList(ArrayList<Product> productList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_products.setLayoutManager(manager);
        rv_products.setItemAnimator(new DefaultItemAnimator());

        if (productList != null) {
            ProductRecyclerAdapter recyclerAdapter = new ProductRecyclerAdapter(productList, this);
            rv_products.setAdapter(recyclerAdapter);
        }
    }
}
