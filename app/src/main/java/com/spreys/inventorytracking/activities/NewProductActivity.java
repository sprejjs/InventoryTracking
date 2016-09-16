package com.spreys.inventorytracking.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.spreys.inventorytracking.R;
import com.spreys.inventorytracking.data.Product;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 16/09/16
 *         Project: InventoryTracking
 *         Contact by: vlad@spreys.com
 */
public class NewProductActivity extends AppCompatActivity {
    @BindView(R.id.name_edit_text)
    EditText nameView;

    @BindView(R.id.price_edit_text)
    EditText priceView;

    @BindView(R.id.quantity_edit_text)
    EditText quantityView;

    @BindView(R.id.email_edit_text)
    EditText emailView;

    @BindView(R.id.activity_name_product_save_button)
    Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_name_product_save_button)
    public void onSave() {
        String name = nameView.getText().toString();
        Double price = Double.valueOf(priceView.getText().toString());
        int quantity = Integer.valueOf(quantityView.getText().toString());
        String email = emailView.getText().toString();

        Product product = new Product(name, email, quantity, price);

        finish();
    }

    @OnTextChanged({R.id.name_edit_text, R.id.price_edit_text, R.id.quantity_edit_text, R.id.email_edit_text})
    public void onProductInformationChanged() {
        boolean enableButton = !TextUtils.isEmpty(nameView.getText()) &&
                !TextUtils.isEmpty(priceView.getText()) &&
                !TextUtils.isEmpty(quantityView.getText()) &&
                !TextUtils.isEmpty(emailView.getText());

        saveButton.setEnabled(enableButton);
    }
}
