package com.example.potatopaloozac.ecommerceproj.ui.products.productlist;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

public class ProductPresenter implements IProductPresenter, IDataManager.OnProductListener {

    private IDataManager dataManager;
    private IProductView productView;
    private Activity activity;

    public ProductPresenter(ProductsActivity activity) {
        dataManager = new DataManager(activity);
        productView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.getProductList(this, activity);
    }

    @Override
    public void getProducts(ArrayList<Product> productList) {
        productView.showProductList(productList);
    }
}
