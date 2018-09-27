package com.example.potatopaloozac.ecommerceproj.data.database.model;

import android.provider.BaseColumns;

public final class FavoriteContract {

    public FavoriteContract() {}

    public static abstract class FavoritesEntry implements BaseColumns {
        public static final String TABLENAME_FAVORITES = "Favorite";
        public static final String COLUMN_ID = "product_id";
        public static final String COLUMN_NAME = "product";
        public static final String COLUMN_INSTOCK = "in_stock";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_IMAGE = "image";
    }
}
