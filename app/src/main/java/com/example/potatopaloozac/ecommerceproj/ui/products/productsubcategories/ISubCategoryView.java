package com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories;

import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;

import java.util.ArrayList;

public interface ISubCategoryView {
    public void showSubCategoriesList(ArrayList<ProductSubCategory> subCategoryList);
}
