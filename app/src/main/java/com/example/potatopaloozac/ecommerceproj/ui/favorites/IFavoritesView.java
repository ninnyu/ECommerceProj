package com.example.potatopaloozac.ecommerceproj.ui.favorites;

import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;

import java.util.ArrayList;

public interface IFavoritesView {
    void showFavorites(ArrayList<Favorite> favoriteList);
}
