package com.example.android.inventoryappliz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Liz on 04/07/2017.
 */

public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String TAG = InventoryDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "inventory.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;


    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_INVENTORY = "CREATE TABLE " + InventoryContract.InventoryEntry.TABLE_NAME + " ("
                + InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InventoryContract.InventoryEntry.COL_NAME + " TEXT NOT NULL, "
                + InventoryContract.InventoryEntry.COL_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + InventoryContract.InventoryEntry.COL_PRICE + " REAL NOT NULL DEFAULT 0.0, "
                + InventoryContract.InventoryEntry.COL_PICTURE + " TEXT NOT NULL DEFAULT 'No images', "
                + InventoryContract.InventoryEntry.COL_DESCRIPTION + " TEXT NOT NULL DEFAULT 'New Product ', "
                + InventoryContract.InventoryEntry.COL_ITEMS_SOLD + " INTEGER NOT NULL DEFAULT 0, "
                + InventoryContract.InventoryEntry.COL_SUPPLIER + " TEXT NOT NULL DEFAULT 'new' "
                + ");";

        db.execSQL(SQL_CREATE_INVENTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + InventoryContract.InventoryEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}