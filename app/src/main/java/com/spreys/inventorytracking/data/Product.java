package com.spreys.inventorytracking.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by vspreys on 9/15/16.
 */

public class Product implements Parcelable {
    private final String name;
    private final String supplierEmail;
    private int quantity;
    private final double price;
    private final String image;

    public Product(String name, String supplierEmail, int quantity, double price, Bitmap image) {
        this(name, supplierEmail, quantity, price, bitMapToString(image));
    }

    public Product(String name, String supplierEmail, int quantity, double price, String image) {
        this.name = name;
        this.supplierEmail = supplierEmail;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public String getEmail() {
        return this.supplierEmail;
    }

    public String getSupplierEmailDescription() {
        return "Email: " + supplierEmail;
    }

    public String getQuantityDescription() {
        return "Quantity: " + this.quantity;
    }

    public String getPriceDescription() {
        return "Price: $" + this.price;
    }

    public Bitmap getImage() {
        return stringToBitMap(image);
    }

    public String getImageAsString() {
        return image;
    }

    public boolean sellItem() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(supplierEmail);
        parcel.writeInt(quantity);
        parcel.writeDouble(price);
        parcel.writeString(image);
    }

    private Product(Parcel in) {
        this.name = in.readString();
        this.supplierEmail = in.readString();
        this.quantity = in.readInt();
        this.price = in.readDouble();
        this.image = in.readString();
    }

    public void retrieveItem() {
        quantity ++;
    }

    private static String bitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    private static Bitmap stringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
