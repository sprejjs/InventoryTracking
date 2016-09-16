package com.spreys.inventorytracking.data;

import android.provider.BaseColumns;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 16/09/16
 *         Project: InventoryTracking
 *         Contact by: vlad@spreys.com
 */
public final class InventoryContract {

    private InventoryContract() {}

    public static final class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "products";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_IMAGE = "image";
    }
}
