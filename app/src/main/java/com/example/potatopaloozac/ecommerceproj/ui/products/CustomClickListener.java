package com.example.potatopaloozac.ecommerceproj.ui.products;

import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;

public interface CustomClickListener {

    interface CategoryClick {
        public void onItemClick(View v, ProductCategory category);
    }

    interface SubCategoryClick {
        public void onItemClick(View v, ProductSubCategory subCategory);
    }

    interface ProductClick {
        public void onItemClick(View v, Product product);
    }

}
