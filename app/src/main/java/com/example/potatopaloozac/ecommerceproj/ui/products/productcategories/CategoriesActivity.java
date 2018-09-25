package com.example.potatopaloozac.ecommerceproj.ui.products.productcategories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.ui.products.CustomClickListener.*;
import com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories.SubCategoriesActivity;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements ICategoryView {

    private RecyclerView rv_categories;
    private ICategoryPresenter categoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        rv_categories = findViewById(R.id.rv_categories);

        categoryPresenter = new CategoryPresenter(this);
        categoryPresenter.onActivityCreated();
    }

    @Override
    public void showCategoriesList(ArrayList<ProductCategory> categoryList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_categories.setLayoutManager(manager);
        rv_categories.setItemAnimator(new DefaultItemAnimator());

        if (categoryList != null) {
            CategoryRecyclerAdapter recyclerAdapter = new CategoryRecyclerAdapter(categoryList, this, new CategoryClick() {
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
}
