package com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;
import com.example.potatopaloozac.ecommerceproj.ui.products.CustomClickListener.*;
import com.example.potatopaloozac.ecommerceproj.ui.products.productlist.ProductsActivity;

import java.util.ArrayList;

public class SubCategoriesActivity extends AppCompatActivity implements ISubCategoryView {

    private RecyclerView rv_subcategories;
    private ISubCategoryPresenter subCategoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);

        rv_subcategories = findViewById(R.id.rv_subcategories);

        subCategoryPresenter = new SubCategoryPresenter(this);
        subCategoryPresenter.onActivityCreated();
    }


    @Override
    public void showSubCategoriesList(ArrayList<ProductSubCategory> subCategoryList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        rv_subcategories.setLayoutManager(manager);
        rv_subcategories.setItemAnimator(new DefaultItemAnimator());

        if (subCategoryList != null) {
            SubCategoryRecyclerAdapter recyclerAdapter = new SubCategoryRecyclerAdapter(subCategoryList, this, new SubCategoryClick() {
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
}
