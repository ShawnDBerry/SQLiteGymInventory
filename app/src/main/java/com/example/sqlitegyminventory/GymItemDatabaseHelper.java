package com.example.sqlitegyminventory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GymItemDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gymitems.db";
    private static final String TABLE_NAME = "gymitems";
    private static int DATABASE_VERSION = 1;

    public static final String COLUMN_GYMITEM_ID = "gymitem_id";
    public static final String COLUMN_GYMITEM_NAME = "gymitem_title";
    public static final String COLUMN_GYMITEM_AMOUNT = "gymitem_amount";


    public GymItemDatabaseHelper(@Nullable Context context,
                                 @Nullable String name,
                                 @Nullable SQLiteDatabase.CursorFactory factory,
                                 int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSqlTableQueryStatement = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_GYMITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_GYMITEM_NAME + " TEXT, " +
                COLUMN_GYMITEM_AMOUNT + " TEXT" +
                ")";

        db.execSQL(createSqlTableQueryStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DATABASE_VERSION = newVersion;
        String updateSqlTableQueryStatement = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(updateSqlTableQueryStatement);
        onCreate(db);
    }


    public Cursor readGymItems(){
        String selectQueryStatement = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        Cursor gymitems = db.rawQuery(selectQueryStatement, null);

        return gymitems;
    }
}
