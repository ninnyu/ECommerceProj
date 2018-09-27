package com.example.potatopaloozac.ecommerceproj.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.ui.products.productcategories.CategoriesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderSummaryActivity extends AppCompatActivity {

    @BindView(R.id.tv_orderSummaryID)
    TextView tvOrderSummaryID;
    @BindView(R.id.tv_orderSummaryPrice)
    TextView tvOrderSummaryPrice;
    @BindView(R.id.tv_orderSummary4Digits)
    TextView tvOrderSummary4Digits;
    @BindView(R.id.tv_orderSummaryZip)
    TextView tvOrderSummaryZip;
    @BindView(R.id.bt_back)
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        ButterKnife.bind(this);

        tvOrderSummaryID.setText(tvOrderSummaryID.getText().toString() + " " + getIntent().getStringExtra("id"));
        tvOrderSummaryPrice.setText(tvOrderSummaryPrice.getText().toString() + " " + getIntent().getIntExtra("total", 0));
        tvOrderSummary4Digits.setText(tvOrderSummary4Digits.getText().toString() + " " + getIntent().getStringExtra("last4"));
        tvOrderSummaryZip.setText(tvOrderSummaryZip.getText().toString() + " " + getIntent().getStringExtra("addressZip"));
    }

    @OnClick(R.id.bt_back)
    public void onViewClicked() {
        Intent i = new Intent(OrderSummaryActivity.this, CategoriesActivity.class);
        startActivity(i);
    }
}
