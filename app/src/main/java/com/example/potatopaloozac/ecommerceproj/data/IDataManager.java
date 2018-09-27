package com.example.potatopaloozac.ecommerceproj.data;

import android.app.Activity;

import com.example.potatopaloozac.ecommerceproj.data.database.IDbHelper;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.network.INetworkHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.TopSeller;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;

import java.util.ArrayList;
import java.util.List;

public interface IDataManager extends IDbHelper, INetworkHelper {

    Product getDetails(Activity activity);

    interface OnCartAddedListener {
        void addedToCart(boolean isAdded);
    }

    interface OnCartListener {
        void readCart(ArrayList<ShoppingCart> cartList);
    }

    interface OnCartUpdatedListener {
        void updatedCart(boolean isUpdated);
    }

    interface OnCartItemDeletedListener {
        void deletedItemFromCart(boolean isDeleted);
    }

    interface OnFavoritesListener {
        void readFavorites(ArrayList<Favorite> favoriteList);
    }

    interface OnFavoritesAddedListener {
        void addedToFavorites(boolean isAdded);
    }

    interface OnFavoritesDeletedListener {
        void deletedFromFavorites(boolean isDeleted);
    }

    interface OnCategoryListener {
        void getCategories(ArrayList<ProductCategory> categoryList);
    }

    interface OnSubCategoryListener {
        void getSubCategories(ArrayList<ProductSubCategory> subCategoryList);
    }

    interface OnProductListener {
        void getProducts(ArrayList<Product> productList);
    }

    interface OnLoginListener {
        void userLogin();
    }

    interface OnUserProfileListener {
        void userProfile(UserProfile profile);
    }

    interface OnRegisterListener {
        void userRegister(boolean isSuccess);
    }

    interface OnProfileUpdateListener {
        void updateProfile(boolean isUpdated);
    }

    interface OnTopSellerListener {
        void getTopSellers(ArrayList<TopSeller> sellerList);
    }
}
