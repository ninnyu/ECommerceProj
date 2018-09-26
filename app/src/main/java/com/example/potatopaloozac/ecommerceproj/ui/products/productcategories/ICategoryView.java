package com.example.potatopaloozac.ecommerceproj.ui.products.productcategories;

import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;

import java.util.ArrayList;

public interface ICategoryView {
    void showCategoriesList(ArrayList<ProductCategory> categoryList);
}
