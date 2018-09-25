package com.example.potatopaloozac.ecommerceproj.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCartContract.*;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

public class DbHelper implements IDbHelper {

    private DbOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    private Context context;

    public DbHelper(Context context) {
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context);
        db = dbOpenHelper.getWritableDatabase();
    }

    @Override
    public void createRow(Product product, int n) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ShoppingCartEntry.COLUMN_PRODUCT_ID, product.getId());
        contentValues.put(ShoppingCartEntry.COLUMN_PRODUCT_NAME, product.getPname());
        contentValues.put(ShoppingCartEntry.COLUMN_QUANTITY, n);
        contentValues.put(ShoppingCartEntry.COLUMN_PRICE, product.getPrice());
        contentValues.put(ShoppingCartEntry.COLUMN_DESC, product.getDescription());
        contentValues.put(ShoppingCartEntry.COLUMN_IMAGE, product.getImage());

        db.insert(ShoppingCartEntry.TABLENAME_SHOPPINGCART, null, contentValues);
    }

    @Override
    public void readRow() {

    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow(Product product) {
        String DELETE_ROW = "DELETE FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART
                + " WHERE " + ShoppingCartEntry.COLUMN_PRODUCT_ID + " = '" + product.getId() + "'";
        db.execSQL(DELETE_ROW);
    }
}
