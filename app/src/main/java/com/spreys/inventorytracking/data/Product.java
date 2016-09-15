package com.spreys.inventorytracking.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vspreys on 9/15/16.
 */

public class Product implements Parcelable {
    private String name;
    private String supplierEmail;
    private int quantity;
    private double price;

    public Product(String name, String supplierEmail, int quantity, double price) {
        this.name = name;
        this.supplierEmail = supplierEmail;
        this.quantity = quantity;
        this.price = price;
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

    public String getSupplierEmailDescription() {
        return "Email: " + supplierEmail;
    }

    public String getQuantityDescription() {
        return "Quantity: " + this.quantity;
    }

    public String getPriceDescription() {
        return "Price: $" + this.price;
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
    }

    private Product(Parcel in) {
        this.name = in.readString();
        this.supplierEmail = in.readString();
        this.quantity = in.readInt();
        this.price = in.readDouble();
    }

    public void retrieveItem() {
        quantity ++;
    }
}
