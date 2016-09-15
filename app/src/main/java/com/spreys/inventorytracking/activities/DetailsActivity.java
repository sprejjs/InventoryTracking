package com.spreys.inventorytracking.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spreys.inventorytracking.R;
import com.spreys.inventorytracking.data.Product;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vspreys on 9/16/16.
 */

public class DetailsActivity extends AppCompatActivity {
    public static final String KEY_PRODUCT = "key_product";

    private Product product;

    @BindView(R.id.details_title)
    TextView titleView;

    @BindView(R.id.details_quantity)
    TextView quantityView;

    @BindView(R.id.details_price)
    TextView priceView;

    @BindView(R.id.details_email)
    TextView emailView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        this.product = getIntent().getExtras().getParcelable(KEY_PRODUCT);
        updateProductDetails();
    }

    private void updateProductDetails() {
        titleView.setText(product.getName());
        quantityView.setText(product.getQuantityDescription());
        priceView.setText(product.getPriceDescription());
        emailView.setText(product.getSupplierEmailDescription());
    }

    @OnClick(R.id.details_track_sale)
    public void onTrackSale() {
        product.sellItem();
        updateProductDetails();
    }

    @OnClick(R.id.details_track_shipment)
    public void onTrackShipment() {
        product.retrieveItem();
        updateProductDetails();
    }

    @OnClick(R.id.details_delete)
    public void onDeleteProduct() {

    }
}
