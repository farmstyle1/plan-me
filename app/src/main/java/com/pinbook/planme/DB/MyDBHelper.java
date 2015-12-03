package com.pinbook.planme.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pinbook.planme.Model.ListActivityModel;

import java.util.ArrayList;

/**
 * Created by admin on 17/11/2558.
 */
public class MyDBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private static final String DB_NAME = "planme";
    private static final int DB_VERSION = 1;

    // Activity Table

    public static final String TABLE_ACTIVITY = "activity";
    public static final String ACTIVITY_ID = "id";
    public static final String ACTIVITY_ACTIVITY = "activity";
    public static final String ACTIVITY_PRICE = "price";
    public static final String ACTIVITY_DATE = "date";
    public static final String ACTIVITY_STATUS = "status";


    // Account Table
    public static final String TABLE_ACCOUNT = "account";
    public static final String ACCOUNT_TOTAL = "total";





    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_ACTIVITY + "( " + ACTIVITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ACTIVITY_ACTIVITY + " TEXT," + ACTIVITY_PRICE + " INTEGER," + ACTIVITY_DATE + " TEXT," + ACTIVITY_STATUS + " TEXT);");
        db.execSQL("CREATE TABLE " + TABLE_ACCOUNT + "( " + ACCOUNT_TOTAL + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_ACCOUNT + " (" + ACCOUNT_TOTAL + ") VALUES (0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDB()
    {
        db = this.getWritableDatabase();
    }

    public void addExpenses(String activity,int price,String date,String status){
        openDB();
        ContentValues values = new ContentValues();
        values.put(ACTIVITY_ACTIVITY,activity);
        values.put(ACTIVITY_PRICE,price);
        values.put(ACTIVITY_DATE,date);
        values.put(ACTIVITY_STATUS,status);
        db.insert(TABLE_ACTIVITY, null, values);
        db.close();


    }

    public Integer queryTotal(){
        int total = 0;
        openDB();
        String strSQL = "SELECT * FROM "+ TABLE_ACCOUNT;
        Cursor cursor = db.rawQuery(strSQL,null);
        if (cursor.moveToFirst()){
            total = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return total;
    }

    public void updateTotal(int total){
        openDB();
        ContentValues values = new ContentValues();
        values.put(ACCOUNT_TOTAL,total);
        db.update(TABLE_ACCOUNT, values, null, null);
        db.close();



    }

    public ArrayList<ListActivityModel> queryActivity(String date){

        ArrayList<ListActivityModel> activity = new ArrayList<ListActivityModel>();
        openDB();
        String strSQL  = "SELECT * FROM " + TABLE_ACTIVITY + " WHERE " + ACTIVITY_DATE + " = '" + date + "'";
        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    ListActivityModel lam = new ListActivityModel(cursor.getInt(0),cursor.getString(1), cursor.getInt(2),cursor.getString(3),cursor.getString(4));


                    activity.add(lam);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return activity;
    }

    public void deleteActivity(int id) {
        openDB();
        db.delete(TABLE_ACTIVITY, "id =" + id, null);
        db.close();

    }


}
