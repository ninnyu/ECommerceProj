package com.example.potatopaloozac.ecommerceproj.ui.products.productdetails;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public class ProductDetailsPresenter implements IProductDetailsPresenter, IDataManager.OnCartAddedListener, IDataManager.OnFavoritesAddedListener {

    private IDataManager dataManager;
    private IProductDetailsView productView;
    private Activity activity;

    public ProductDetailsPresenter(ProductDetailsActivity activity) {
        dataManager = new DataManager(activity);
        productView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        Product product = dataManager.getDetails(activity);

        productView.showProductDetails(product);
    }

    @Override
    public void onAddToCartButtonClicked(Product product, int n) {
        Log.d("tag", "in proddetailspresenter, addtocartbuttonclicked " + product.getId() + n);
        dataManager.createRow(this, product, n);
    }

    @Override
    public void onAddToFavoritesButtonClicked(Product product) {
        dataManager.createRow(this, product);
    }

    @Override
    public void addedToCart(boolean isAdded) {
        if (isAdded)
            productView.showToast("Added to cart");
        else
            productView.showToast("Failed to add to cart");
    }

    @Override
    public void addedToFavorites(boolean isAdded) {
        if (isAdded)
            productView.showToast("Added to favorites");
        else
            productView.showToast("Failed to add to favorites");
    }
}
