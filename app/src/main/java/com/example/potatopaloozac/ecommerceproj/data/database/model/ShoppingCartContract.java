package com.example.potatopaloozac.ecommerceproj.data.database.model;

import android.provider.BaseColumns;

public final class ShoppingCartContract {

    public ShoppingCartContract() {}

    public static abstract class ShoppingCartEntry implements BaseColumns {
        public static final String TABLENAME_SHOPPINGCART = "ShoppingCart";
        public static final String COLUMN_PRODUCT_ID = "product_id";
        public static final String COLUMN_PRODUCT_NAME = "product";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_INCART = "in_cart";
        public static final String COLUMN_INFAVORITES = "in_favorites";

    }
}
