package com.example.userauthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "UserDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT," +
                "email TEXT," +
                "password TEXT," +
                "dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public boolean insertUser(String u, String e, String p, String d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", u);
        cv.put("email", e);
        cv.put("password", p);
        cv.put("dob", d);
        return db.insert("users", null, cv) != -1;
    }

    public boolean login(String e, String p) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT * FROM users WHERE email=? AND password=?",
                new String[]{e, p});
        return c.getCount() > 0;
    }

    public boolean updatePassword(String e, String p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("password", p);
        return db.update("users", cv, "email=?", new String[]{e}) > 0;
    }

    public boolean deleteUser(String e) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users", "email=?", new String[]{e}) > 0;
    }
}
