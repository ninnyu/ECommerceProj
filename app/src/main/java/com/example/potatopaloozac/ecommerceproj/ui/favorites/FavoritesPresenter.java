package com.example.potatopaloozac.ecommerceproj.ui.favorites;

import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.DataManager;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;

import java.util.ArrayList;

public class FavoritesPresenter implements IFavoritesPresenter, IDataManager.OnFavoritesDeletedListener, IDataManager.OnFavoritesListener {

    private IFavoritesView favoritesView;
    private IDataManager dataManager;

    public FavoritesPresenter(FavoritesActivity activity) {
        favoritesView = activity;
        dataManager = new DataManager(activity);
    }

    @Override
    public void onActivityCreated() {
        dataManager.readRow(this);
    }

    @Override
    public void onRemoveButtonClicked(View v, Favorite favorite) {
        dataManager.deleteRow(this, favorite);
    }

    @Override
    public void deletedFromFavorites(boolean isDeleted) {
        if (isDeleted) {
            onActivityCreated();
        }
    }

    @Override
    public void readFavorites(ArrayList<Favorite> favoriteList) {
        favoritesView.showFavorites(favoriteList);
    }
}
