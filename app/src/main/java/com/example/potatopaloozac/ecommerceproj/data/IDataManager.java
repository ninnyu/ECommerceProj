package com.example.potatopaloozac.ecommerceproj.data;

import com.example.potatopaloozac.ecommerceproj.data.database.IDbHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.INetworkHelper;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Login;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;

import java.util.ArrayList;

public interface IDataManager extends IDbHelper, INetworkHelper {

    interface OnResponseListener {

    }

    interface OnCategoryListener {
        public void getCategories(ArrayList<ProductCategory> categoryList);
    }

    interface OnSubCategoryListener {
        public void getSubCategories(ArrayList<ProductSubCategory> subCategoryList);
    }

    interface OnProductListener {
        public void getProducts(ArrayList<Product> productList);
    }

    interface OnLoginListener {
        public void userLogin(Login login);
    }

    interface OnRegisterListener {
        public void userRegister(boolean isSuccess);
    }
}
