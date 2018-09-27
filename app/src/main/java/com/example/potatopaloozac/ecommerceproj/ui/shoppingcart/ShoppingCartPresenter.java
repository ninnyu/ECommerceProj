package com.example.potatopaloozac.ecommerceproj.ui.shoppingcart;

import android.app.Activity;
import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;

import java.util.ArrayList;

public class ShoppingCartPresenter implements IShoppingCartPresenter, IDataManager.OnCartListener, IDataManager.OnCartUpdatedListener, IDataManager.OnCartItemDeletedListener {

    private IShoppingCartView cartView;
    private IDataManager dataManager;
    private Activity activity;

    public ShoppingCartPresenter(ShoppingCartActivity activity) {
        dataManager = new DataManager(activity);
        this.cartView = activity;
        this.activity = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.readRow(this);
    }

    @Override
    public void onUpdateButtonClicked(View v, ShoppingCart cart, int n) {
        dataManager.updateRow(this, cart, n);
    }

    @Override
    public void onRemoveButtonClicked(View v, ShoppingCart cart) {
        dataManager.deleteRow(this, cart);
    }

    @Override
    public void readCart(ArrayList<ShoppingCart> cartList) {
        cartView.showCart(cartList);
    }

    @Override
    public void updatedCart(boolean isUpdated) {
        if (isUpdated) {
            onActivityCreated();
        }
    }

    @Override
    public void deletedItemFromCart(boolean isDeleted) {
        if (isDeleted) {
            onActivityCreated();
        }
    }
}
