package com.spreys.inventorytracking.data;

/**
 * Created by vspreys on 9/15/16.
 */

public class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
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
}
