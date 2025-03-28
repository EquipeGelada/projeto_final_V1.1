package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {
    private SQLiteDatabase database;

    public UsuarioDAO(SQLiteDatabase database) {
        this.database = database;
    }

    public void inserirUsuario(usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        database.insert("Usuario", null, values);
    }

    public void excluirUsuario(int id) {
        database.delete("Usuario", "id = ?", new String[]{String.valueOf(id)});
    }

    public Cursor listarUsuarios() {
        return database.query("Usuario", null, null, null, null, null, null);
    }
}
