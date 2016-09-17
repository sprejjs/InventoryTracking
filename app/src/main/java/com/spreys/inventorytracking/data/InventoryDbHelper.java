package com.spreys.inventorytracking.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 16/09/16
 *         Project: InventoryTracking
 *         Contact by: vlad@spreys.com
 */
public class InventoryDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String DATABASE_NAME = "Inventory.db";
    private static final String REAL_TYPE = " REAL";
    private static final int DATABASE_VERSION = 2;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + InventoryContract.ProductEntry.TABLE_NAME + " (" +
                    InventoryContract.ProductEntry._ID + " INTEGER PRIMARY KEY," +
                    InventoryContract.ProductEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    InventoryContract.ProductEntry.COLUMN_EMAIL + TEXT_TYPE + COMMA_SEP +
                    InventoryContract.ProductEntry.COLUMN_QUANTITY + INTEGER_TYPE + COMMA_SEP +
                    InventoryContract.ProductEntry.COLUMN_PRICE + REAL_TYPE + COMMA_SEP +
                    InventoryContract.ProductEntry.COLUMN_IMAGE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + InventoryContract.ProductEntry.TABLE_NAME;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQLiteDatabase db = getWritableDatabase();
        //Delete the old entries
        db.execSQL(SQL_DELETE_ENTRIES);
        //Create the table again
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public int updateProduct(Product product) {
        SQLiteDatabase db = getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(InventoryContract.ProductEntry.COLUMN_QUANTITY, product.getQuantity());

        // Which row to update, based on the title
        String selection = InventoryContract.ProductEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(product.getId()) };

        return db.update(
                InventoryContract.ProductEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public List<Product> getProducts() {
        SQLiteDatabase db = getReadableDatabase();


        Cursor cursor =  db.query(
                InventoryContract.ProductEntry.TABLE_NAME,                     // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        ArrayList<Product> products = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(InventoryContract.ProductEntry._ID));
            String name = cursor.getString(cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_EMAIL));
            int quantity = cursor.getInt(cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_QUANTITY));
            double price = cursor.getDouble(cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_PRICE));
            String image = cursor.getString(cursor.getColumnIndex(InventoryContract.ProductEntry.COLUMN_IMAGE));

            products.add(new Product(id, name, email, quantity, price, image));
        }
        cursor.close();

        return products;
    }

    public long saveNewProduct(Product product) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.ProductEntry.COLUMN_NAME, product.getName());
        values.put(InventoryContract.ProductEntry.COLUMN_EMAIL, product.getEmail());
        values.put(InventoryContract.ProductEntry.COLUMN_QUANTITY, product.getQuantity());
        values.put(InventoryContract.ProductEntry.COLUMN_PRICE, product.getPrice());
        values.put(InventoryContract.ProductEntry.COLUMN_IMAGE, product.getImageAsString());

        return db.insert(InventoryContract.ProductEntry.TABLE_NAME, null, values);
    }

    public void deleteProduct(Product product) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = InventoryContract.ProductEntry._ID + " = ?";
        String[] selectionArgs = { String.valueOf(product.getId()) };

        db.delete(InventoryContract.ProductEntry.TABLE_NAME, selection, selectionArgs);
    }
}
