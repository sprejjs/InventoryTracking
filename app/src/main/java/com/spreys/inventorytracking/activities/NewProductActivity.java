package com.spreys.inventorytracking.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.spreys.inventorytracking.R;
import com.spreys.inventorytracking.data.Product;

import java.io.IOException;
import java.io.InputStream;

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
    private static final int SELECT_PHOTO = 100;

    private Bitmap selectedImage;

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

    @BindView(R.id.photo_image_view)
    ImageView photoImageView;

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

    @OnClick(R.id.add_photo_button)
    public void onAddPhoto() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    @OnTextChanged({R.id.name_edit_text, R.id.price_edit_text, R.id.quantity_edit_text, R.id.email_edit_text})
    public void onProductInformationChanged() {
        boolean enableButton = !TextUtils.isEmpty(nameView.getText()) &&
                !TextUtils.isEmpty(priceView.getText()) &&
                !TextUtils.isEmpty(quantityView.getText()) &&
                !TextUtils.isEmpty(emailView.getText()) &&
                selectedImage != null;

        saveButton.setEnabled(enableButton);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        Uri selectedImage = imageReturnedIntent.getData();
                        InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                        this.selectedImage = BitmapFactory.decodeStream(imageStream);
                        photoImageView.setImageBitmap(this.selectedImage);
                        onProductInformationChanged();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
        }
    }
}
