package com.example.potatopaloozac.ecommerceproj.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.data.database.model.ShoppingCart;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity implements IOrderView {

    @BindView(R.id.tv_orderTotalPrice)
    TextView tvOrderTotalPrice;
    @BindView(R.id.bt_placeOrder)
    Button btPlaceOrder;
    @BindView(R.id.tv_titlebar)
    TextView tvTitlebar;

    private RecyclerView rv_order;
    private IOrderPresenter orderPresenter;
    private Simplify simplify;
    private CardEditor cardEditor;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        tvTitlebar.setText(R.string.checkout);

        rv_order = findViewById(R.id.rv_order);

        cardEditor = findViewById(R.id.card_editor);

        simplify = new Simplify();
        simplify.setApiKey("sbpb_ZmFmNGQ4NjUtNWI4Ni00NTYyLWE5MDQtZTE4YWEzODRmODU4");

        orderPresenter = new OrderPresenter(this);
        orderPresenter.onActivityCreated();
    }

    @Override
    public void showOrder(ArrayList<ShoppingCart> cartList) {

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());

        Log.d("tag", "in orderactivity showorder: " + cartList.get(0));

        rv_order.setLayoutManager(manager);
        rv_order.setItemAnimator(new DefaultItemAnimator());

        OrderReclyclerAdapter recyclerAdapter = new OrderReclyclerAdapter(this, cartList);
        rv_order.setAdapter(recyclerAdapter);

        for (int i = 0; i < cartList.size(); i++) {
            int quantity = cartList.get(i).getQuantity();
            int price = Integer.parseInt(cartList.get(i).getProduct().getPrice());

            total += quantity * price;
        }

        String totalString = Integer.toString(total);

        tvOrderTotalPrice.setText(totalString);
    }

    @OnClick(R.id.bt_placeOrder)
    public void onViewClicked() {

        simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback() {
            @Override
            public void onSuccess(CardToken cardToken) {
                Log.d("tag", "onSuccess: " + cardToken.getCard().toString());

                Intent i = new Intent(OrderActivity.this, OrderSummaryActivity.class);
                i.putExtra("id", cardToken.getCard().getId());
                i.putExtra("type", cardToken.getCard().getType());
                i.putExtra("last4", cardToken.getCard().getLast4());
                i.putExtra("addressZip", cardToken.getCard().getAddressZip());
                i.putExtra("total", total);
                startActivity(i);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("tag", "onError: " + throwable.getMessage());
                Toast.makeText(OrderActivity.this, "Payment failed due to invalid card details. Please try again!", Toast.LENGTH_SHORT).show();
            }
        });

        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                btPlaceOrder.setEnabled(cardEditor.isValid());
            }
        });
    }
}