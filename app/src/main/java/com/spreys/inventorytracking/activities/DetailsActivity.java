package com.spreys.inventorytracking.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.spreys.inventorytracking.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vspreys on 9/16/16.
 */

public class DetailsActivity extends AppCompatActivity {
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
    }

    @OnClick(R.id.details_track_sale)
    public void onTrackSale() {

    }

    @OnClick(R.id.details_track_shipment)
    public void onTrackShipment() {

    }

    @OnClick(R.id.details_delete)
    public void onDeleteProduct() {

    }
}
