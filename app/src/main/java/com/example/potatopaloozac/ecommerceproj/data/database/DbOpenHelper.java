package com.example.potatopaloozac.ecommerceproj.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                + ShoppingCartEntry.COLUMN_PRODUCT_ID + " INT, "
                + ShoppingCartEntry.COLUMN_PRODUCT_NAME + " TEXT, "
                + ShoppingCartEntry.COLUMN_QUANTITY + " INT, "
                + ShoppingCartEntry.COLUMN_PRICE + " TEXT, "
                + ShoppingCartEntry.COLUMN_DESC + " TEXT, "
                + ShoppingCartEntry.COLUMN_IMAGE + " TEXT, "
                + ShoppingCartEntry.COLUMN_INCART + " INTEGER DEFAULT 0, "
                + ShoppingCartEntry.COLUMN_INFAVORITES + " INTEGER DEFAULT 0)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ShoppingCartEntry.TABLENAME_SHOPPINGCART);
        onCreate(db);
    }
}
