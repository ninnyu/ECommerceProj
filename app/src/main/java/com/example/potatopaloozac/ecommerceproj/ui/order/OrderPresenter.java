package com.example.potatopaloozac.ecommerceproj.ui.order;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;

import java.util.ArrayList;

public class OrderPresenter implements IOrderPresenter, IDataManager.OnCartListener {

    private IDataManager dataManager;
    private IOrderView orderView;

    public OrderPresenter(OrderActivity activity) {
        dataManager = new DataManager(activity);
        orderView = activity;
    }

    @Override
    public void onActivityCreated() {
        dataManager.readRow(this);
    }

    @Override
    public void readCart(ArrayList<ShoppingCart> cartList) {
        orderView.showOrder(cartList);
    }
}
