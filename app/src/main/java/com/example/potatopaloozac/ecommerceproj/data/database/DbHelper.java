package com.example.potatopaloozac.ecommerceproj.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.database.model.Favorite;
import com.example.potatopaloozac.ecommerceproj.data.database.model.FavoriteContract.*;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCartContract.*;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;

import java.util.ArrayList;

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
    public void createRow(IDataManager.OnCartAddedListener cartAddedListener, Product product, int n) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(ShoppingCartEntry.COLUMN_ID, product.getId());
        contentValues.put(ShoppingCartEntry.COLUMN_NAME, product.getPname());
        contentValues.put(ShoppingCartEntry.COLUMN_QUANTITY, n);
        contentValues.put(ShoppingCartEntry.COLUMN_PRICE, product.getPrice());
        contentValues.put(ShoppingCartEntry.COLUMN_DESC, product.getDescription());
        contentValues.put(ShoppingCartEntry.COLUMN_IMAGE, product.getImage());

        String query = "SELECT * FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART
                + " WHERE " + ShoppingCartEntry.COLUMN_ID + " = '" + product.getId() + "'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            Log.d("tag", "in dbhelper, cursor moved to first " + query);
            updateCart(product, n);
        } else {
            Log.d("tag", "in dbhelper, create row " + product.getId() + n);
            db.insert(ShoppingCartEntry.TABLENAME_SHOPPINGCART, null, contentValues);
        }
        cartAddedListener.addedToCart(true);
    }

    @Override
    public void readRow(IDataManager.OnCartListener cartListener) {
        ArrayList<ShoppingCart> cartList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART, null);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_NAME));
                String quantity = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_QUANTITY));
                String price = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_PRICE));
                String desc = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_DESC));
                String image = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_IMAGE));

                Product product = new Product(id, name, price, desc, image);
                ShoppingCart cartItem = new ShoppingCart(product, Integer.parseInt(quantity));
                cartList.add(cartItem);
            } while (cursor.moveToNext());
        }
        cartListener.readCart(cartList);
    }

    @Override
    public void updateRow(IDataManager.OnCartUpdatedListener cartUpdatedListener, ShoppingCart cart, int n) {
        if (n > 0) {
            String UPDATE_ROW = "UPDATE " + ShoppingCartEntry.TABLENAME_SHOPPINGCART
                    + " SET " + ShoppingCartEntry.COLUMN_QUANTITY + " = '" + n + "' WHERE "
                    + ShoppingCartEntry.COLUMN_ID + " = " + cart.getProduct().getId();

            Log.d("tag", "in dbhelper, updaterow with cart " + UPDATE_ROW);
            db.execSQL(UPDATE_ROW);
        } else {
            deleteRow(cart);
        }
        cartUpdatedListener.updatedCart(true);
    }

    @Override
    public void deleteRow(IDataManager.OnCartItemDeletedListener itemDeletedListener, ShoppingCart cart) {
        String DELETE_ROW = "DELETE FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART + " WHERE "
                + ShoppingCartEntry.COLUMN_ID + " = '" + cart.getProduct().getId() + "'";

        Log.d("tag", "in dbhelper, deleterow with cart " + DELETE_ROW);
        db.execSQL(DELETE_ROW);

        itemDeletedListener.deletedItemFromCart(true);
    }

    @Override
    public void createRow(IDataManager.OnFavoritesAddedListener favoritesAddedListener, Product product) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(FavoritesEntry.COLUMN_ID, product.getId());
        contentValues.put(FavoritesEntry.COLUMN_NAME, product.getPname());
        contentValues.put(FavoritesEntry.COLUMN_INSTOCK, product.getQuantityInStock());
        contentValues.put(FavoritesEntry.COLUMN_PRICE, product.getPrice());
        contentValues.put(FavoritesEntry.COLUMN_DESC, product.getDescription());
        contentValues.put(FavoritesEntry.COLUMN_IMAGE, product.getImage());

        String query = "SELECT * FROM " + FavoritesEntry.TABLENAME_FAVORITES
                + " WHERE " + FavoritesEntry.COLUMN_ID + " = '" + product.getId() + "'";

        Cursor cursor = db.rawQuery(query, null);

        if (!cursor.moveToFirst()) {
            Log.d("tag", "in dbhelper, create row " + product.getId());
            db.insert(FavoritesEntry.TABLENAME_FAVORITES, null, contentValues);
        }
        favoritesAddedListener.addedToFavorites(true);
    }

    @Override
    public void readRow(IDataManager.OnFavoritesListener favoritesListener) {
        ArrayList<Favorite> favoriteList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + FavoritesEntry.TABLENAME_FAVORITES, null);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_NAME));
                String quantity = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_INSTOCK));
                String price = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_PRICE));
                String desc = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_DESC));
                String image = cursor.getString(cursor.getColumnIndex(FavoritesEntry.COLUMN_IMAGE));

                Product product = new Product(id, name, price, desc, image);
                Favorite favoriteItem = new Favorite(product);
                favoriteList.add(favoriteItem);
            } while (cursor.moveToNext());
        }
        favoritesListener.readFavorites(favoriteList);
    }

    @Override
    public void deleteRow(IDataManager.OnFavoritesDeletedListener favoritesDeletedListener, Favorite favorite) {
        String DELETE_ROW = "DELETE FROM " + FavoritesEntry.TABLENAME_FAVORITES + " WHERE "
                + FavoritesEntry.COLUMN_ID + " = '" + favorite.getProduct().getId() + "'";

        Log.d("tag", "in dbhelper, deleterow with cart " + DELETE_ROW);
        db.execSQL(DELETE_ROW);

        favoritesDeletedListener.deletedFromFavorites(true);
    }

    public void updateCart(Product product, int n) {
        Cursor cursor = db.rawQuery("SELECT * FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART
                + " WHERE " + ShoppingCartEntry.COLUMN_ID + " = '" + product.getId() + "'", null);

        cursor.moveToFirst();

        String quantity = cursor.getString(cursor.getColumnIndex(ShoppingCartEntry.COLUMN_QUANTITY));

        int x = Integer.parseInt(quantity) + n;

        String UPDATE_ROW = "UPDATE " + ShoppingCartEntry.TABLENAME_SHOPPINGCART
                + " SET " + ShoppingCartEntry.COLUMN_QUANTITY + " = '" + x + "' WHERE "
                + ShoppingCartEntry.COLUMN_ID + " = " + product.getId();

        Log.d("tag", "in dbhelper, updatecart " + UPDATE_ROW);
        db.execSQL(UPDATE_ROW);
    }

    public void deleteRow(ShoppingCart cart) {
        String DELETE_ROW = "DELETE FROM " + ShoppingCartEntry.TABLENAME_SHOPPINGCART + " WHERE "
                + ShoppingCartEntry.COLUMN_ID + " = '" + cart.getProduct().getId() + "'";

        Log.d("tag", "in dbhelper, deleterow with cart " + DELETE_ROW);
        db.execSQL(DELETE_ROW);
    }
}
