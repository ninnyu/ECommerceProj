package com.example.potatopaloozac.ecommerceproj.ui.products.productsubcategories;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;

import java.util.ArrayList;

public class SubCategoryPresenter implements ISubCategoryPresenter, IDataManager.OnSubCategoryListener {

    private IDataManager dataManager;
    private ISubCategoryView subCategoryView;
    Activity activity;

    public SubCategoryPresenter(SubCategoriesActivity activity) {
        dataManager = new DataManager(activity);
        subCategoryView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.getSubCategoryList(this, activity);
    }

    @Override
    public void getSubCategories(ArrayList<ProductSubCategory> subCategoryList) {
        subCategoryView.showSubCategoriesList(subCategoryList);
    }
}
