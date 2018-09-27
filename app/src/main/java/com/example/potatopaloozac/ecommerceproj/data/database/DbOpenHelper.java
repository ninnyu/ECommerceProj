package com.example.potatopaloozac.ecommerceproj.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.potatopaloozac.ecommerceproj.data.database.model.FavoriteContract.*;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCartContract.*;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String ECOMMERCEDATABASE = "ECommerceDatabase";
    public static final int VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, ECOMMERCEDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + ShoppingCartEntry.TABLENAME_SHOPPINGCART + " ("
                + ShoppingCartEntry.COLUMN_ID + " INT, "
                + ShoppingCartEntry.COLUMN_NAME + " TEXT, "
                + ShoppingCartEntry.COLUMN_QUANTITY + " INT, "
                + ShoppingCartEntry.COLUMN_PRICE + " INT, "
                + ShoppingCartEntry.COLUMN_DESC + " TEXT, "
                + ShoppingCartEntry.COLUMN_IMAGE + " TEXT )";

        String CREATE_TABLE2 = "CREATE TABLE " + FavoritesEntry.TABLENAME_FAVORITES + " ("
                + FavoritesEntry.COLUMN_ID + " INT, "
                + FavoritesEntry.COLUMN_NAME + " TEXT, "
                + FavoritesEntry.COLUMN_INSTOCK + " INT, "
                + FavoritesEntry.COLUMN_PRICE + " INT, "
                + FavoritesEntry.COLUMN_DESC + " TEXT, "
                + FavoritesEntry.COLUMN_IMAGE + " TEXT )";

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ShoppingCartEntry.TABLENAME_SHOPPINGCART);
        db.execSQL("DROP TABLE IF EXISTS " + FavoritesEntry.TABLENAME_FAVORITES);

        onCreate(db);
    }
}
