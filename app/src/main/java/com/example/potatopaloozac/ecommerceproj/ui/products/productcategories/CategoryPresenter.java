package com.example.potatopaloozac.ecommerceproj.ui.products.productcategories;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;

import java.util.ArrayList;

public class CategoryPresenter implements ICategoryPresenter, IDataManager.OnCategoryListener {

    private IDataManager dataManager;
    private ICategoryView categoryView;

    public CategoryPresenter (CategoriesActivity activity) {
        dataManager = new DataManager(activity);
        categoryView = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.getCategoryList(this);
    }

    @Override
    public void getCategories(ArrayList<ProductCategory> categoryList) {
        categoryView.showCategoriesList(categoryList);
    }
}
