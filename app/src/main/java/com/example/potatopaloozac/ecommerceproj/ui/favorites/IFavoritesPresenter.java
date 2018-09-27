package com.example.potatopaloozac.ecommerceproj.ui.favorites;

import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;

public interface IFavoritesPresenter {
    void onActivityCreated();
    void onRemoveButtonClicked(View v, Favorite favorite);
}
