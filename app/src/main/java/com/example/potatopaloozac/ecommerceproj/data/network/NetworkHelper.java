package com.example.potatopaloozac.ecommerceproj.data.network;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.potatopaloozac.ecommerceproj.data.network.model.TopSeller;
import com.example.potatopaloozac.ecommerceproj.utils.AppController;
import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.IDataManager;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Login;
import com.example.potatopaloozac.ecommerceproj.data.network.model.Product;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.ProductSubCategory;
import com.example.potatopaloozac.ecommerceproj.data.network.model.UserProfile;
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkHelper implements INetworkHelper {

    private ArrayList<ProductCategory> categoryList;
    private ArrayList<ProductSubCategory> subCategoryList;
    private ArrayList<Product> productList;
    private ArrayList<TopSeller> sellerList;

    private ProductCategory productCategory;
    private ProductSubCategory productSubCategory;
    private Product product;
    private TopSeller seller;

    private Login login;
    private UserProfile userProfile;

    private Context context;
    private ProgressDialog pDialog;
    private SharedPreferences sp;

    public NetworkHelper(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("userlogin", Context.MODE_PRIVATE);
    }

    @Override
    public void getCategoryList(final IDataManager.OnCategoryListener categoryListener) {

        categoryList = new ArrayList<>();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.loadingData));
        pDialog.show();

        String url = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key="
                + sp.getString("apikey","") + "&user_id=" + sp.getString("id", "");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {
                    pDialog.dismiss();
                    try {
                        JSONArray jsonArray = response.getJSONArray("category");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject a = jsonArray.getJSONObject(i);

                            String cid = a.getString("cid");
                            String cname = a.getString("cname");
                            String cdiscription = a.getString("cdiscription");
                            String cimagerl = a.getString("cimagerl");

                            productCategory = new ProductCategory(cid, cname, cdiscription, cimagerl);
                            categoryList.add(productCategory);
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle(R.string.alertTimeout);
                        alertDialogBuilder.setMessage(R.string.alertTimeoutMessage);

                        alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context, LoginActivity.class);
                                context.startActivity(i);
                            }
                        });

                        alertDialogBuilder.show();
                    }
                    categoryListener.getCategories(categoryList);
                } else {
                    pDialog.setMessage(context.getResources().getString(R.string.serverNotResponding));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    public void getSubCategoryList(final IDataManager.OnSubCategoryListener subCategoryListener, Activity activity) {

        subCategoryList = new ArrayList<>();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.loadingData));
        pDialog.show();

        Bundle b = activity.getIntent().getExtras();
        String cid = b.getString("cid");

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("cid", cid);
        editor.commit();

        String url = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_sub_category.php?Id=" + cid + "&api_key="
                + sp.getString("apikey","") + "&user_id=" + sp.getString("id", "");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {
                    pDialog.dismiss();
                    try {
                        JSONArray jsonArray = response.getJSONArray("subcategory");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject a = jsonArray.getJSONObject(i);

                            String scid = a.getString("scid");
                            String scname = a.getString("scname");
                            String scdiscription = a.getString("scdiscription");
                            String scimageurl = a.getString("scimageurl");

                            productSubCategory = new ProductSubCategory(scid, scname, scdiscription, scimageurl);
                            subCategoryList.add(productSubCategory);
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle(R.string.alertTimeout);
                        alertDialogBuilder.setMessage(R.string.alertTimeoutMessage);

                        alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context, LoginActivity.class);
                                context.startActivity(i);
                            }
                        });

                        alertDialogBuilder.show();
                    }
                    subCategoryListener.getSubCategories(subCategoryList);
                } else {
                    pDialog.setMessage(context.getResources().getString(R.string.serverNotResponding));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    public void getProductList(final IDataManager.OnProductListener productListener, Activity activity) {

        productList = new ArrayList<>();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.loadingData));
        pDialog.show();

        Bundle b = activity.getIntent().getExtras();
        String cid = sp.getString("cid", "");
        String scid = b.getString("scid");

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("scid", scid);
        editor.commit();

        String url = "http://rjtmobile.com/ansari/shopingcart/androidapp/product_details.php?cid=" + cid + "&scid="
                + scid + "&api_key=" + sp.getString("apikey","") + "&user_id=" + sp.getString("id", "");

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {
                    pDialog.dismiss();
                    try {
                        JSONArray jsonArray = response.getJSONArray("products");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject a = jsonArray.getJSONObject(i);

                            String id = a.getString("id");
                            String pname = a.getString("pname");
                            String quantity = a.getString("quantity");
                            String prize = a.getString("prize");
                            String discription = a.getString("discription");
                            String image = a.getString("image");

                            product = new Product(id, pname, quantity, prize, discription, image);
                            productList.add(product);
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle(R.string.alertTimeout);
                        alertDialogBuilder.setMessage(R.string.alertTimeoutMessage);

                        alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context, LoginActivity.class);
                                context.startActivity(i);
                            }
                        });

                        alertDialogBuilder.show();
                    }
                    productListener.getProducts(productList);
                } else {
                    pDialog.setMessage(context.getResources().getString(R.string.serverNotResponding));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    public void login(final IDataManager.OnLoginListener loginListener) {

        login = new Login(sp.getString("mobile", ""), sp.getString("password", ""));

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLoggedin", false);
        editor.commit();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.loggingin));
        pDialog.show();

        String url = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile="
                + login.getMobile() + "&password=" + login.getPassword();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    pDialog.dismiss();
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                    try {
                        JSONObject a = response.getJSONObject(0);

                        String id = a.getString("id"),
                                firstname = a.getString("firstname"),
                                lastname = a.getString("lastname"),
                                email = a.getString("email"),
                                mobile = a.getString("mobile"),
                                appapikey = a.getString("appapikey ");

                        loginListener.userLogin(login);

                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("userid", id);
                        editor.putString("userfname", firstname);
                        editor.putString("userlname", lastname);
                        editor.putString("useremail", email);
                        editor.putString("usermobile", mobile);
                        editor.putString("apikey", appapikey);
                        editor.putString("id", id);
                        editor.commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle(R.string.invalid);
                alertDialogBuilder.setMessage(R.string.alertWrongUser);

                alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialogBuilder.show();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void getUserProfile(IDataManager.OnUserProfileListener profileListener) {
        String id = sp.getString("userid", "");
        String fname = sp.getString("userfname", "");
        String lname = sp.getString("userlname", "");
        String email = sp.getString("useremail", "");
        String mobile = sp.getString("usermobile", "");

        userProfile = new UserProfile(id, fname, lname, email, mobile);

        profileListener.userProfile(userProfile);
    }

    @Override
    public void register(final IDataManager.OnRegisterListener registerListener, UserProfile profile) {

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.registering));
        pDialog.show();

        String url = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_reg.php?fname="
                + profile.getFname() + "&lname=" + profile.getLname() + "&address=" + profile.getAddress()
                + "&email=" + profile.getEmail() + "&mobile=" + profile.getMobile() + "&password=" + profile.getPassword();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.dismiss();
                if (response.equals("successfully registered")) {
                    registerListener.userRegister(true);
                } else {
                    registerListener.userRegister(false);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    @Override
    public void getSellerList(final IDataManager.OnTopSellerListener sellerListener) {

        sellerList = new ArrayList<>();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage(context.getResources().getString(R.string.loadingData));
        pDialog.show();

        String url = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_top_sellers.php?";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response != null) {
                    pDialog.dismiss();
                    try {
                        JSONArray jsonArray = response.getJSONArray("Top sellers");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject a = jsonArray.getJSONObject(i);

                            String id = a.getString("id");
                            String sellername = a.getString("sellername");
                            String sellerdeal = a.getString("sellerdeal");
                            String sellerrating = a.getString("sellerrating");
                            String sellerlogo = a.getString("sellerlogo");

                            seller = new TopSeller(id, sellername, sellerdeal, sellerrating, sellerlogo);
                            sellerList.add(seller);
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setTitle(R.string.alertTimeout);
                        alertDialogBuilder.setMessage(R.string.alertTimeoutMessage);

                        alertDialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context, LoginActivity.class);
                                context.startActivity(i);
                            }
                        });

                        alertDialogBuilder.show();
                    }
                    sellerListener.getTopSellers(sellerList);
                } else {
                    pDialog.setMessage(context.getResources().getString(R.string.serverNotResponding));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }


}
