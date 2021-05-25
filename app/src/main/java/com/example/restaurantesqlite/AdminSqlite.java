package com.example.restaurantesqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSqlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "administrator";

    public AdminSqlite(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DataBase) {
        DataBase.execSQL("create table usuarios(id INTEGER PRIMARY KEY autoincrement, nombre text, contraseña text,celular INTEGER, email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
