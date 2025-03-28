package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sistema.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação das tabelas
        String createUsuarioTable = "CREATE TABLE Usuario (id INTEGER PRIMARY KEY, nome TEXT, email TEXT)";
        String createProdutoTable = "CREATE TABLE Produto (id INTEGER PRIMARY KEY, nome TEXT, preco REAL)";
        db.execSQL(createUsuarioTable);
        db.execSQL(createProdutoTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Produto");
        onCreate(db);
    }
}


