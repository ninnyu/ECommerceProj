package com.example.potatopaloozac.ecommerceproj.utils;

import android.view.View;

import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;

public interface CustomClickListener {

    interface CategoryClick {
        void onItemClick(View v, ProductCategory category);
    }

    interface SubCategoryClick {
        void onItemClick(View v, ProductSubCategory subCategory);
    }

    interface ProductClick {
        void onItemClick(View v, Product product);
    }

    interface CartUpdateRemoveClick {
        void onUpdateItemClick(View v, ShoppingCart cart, int n);
        void onRemoveItemClick(View v, ShoppingCart cart);
    }

    interface FavoriteRemoveClick {
        void onRemoveItemClick(View v, Favorite favorite);
    }

}
