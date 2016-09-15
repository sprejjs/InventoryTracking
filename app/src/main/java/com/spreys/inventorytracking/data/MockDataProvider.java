package com.spreys.inventorytracking.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vspreys on 9/15/16.
 */

public class MockDataProvider {
    public static List<Product> GetMockData() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Headphones", "test@test.com", 10, 59.99));
        products.add(new Product("iPad mini", "test@test.com", 15, 99.99));
        products.add(new Product("iPhone 7", "test@test.com", 3, 1100));
        return products;
    }
}
