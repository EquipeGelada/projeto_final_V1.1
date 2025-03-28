package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityUsuariosBinding;

public class UsuariosActivity extends AppCompatActivity {

    private ActivityUsuariosBinding binding;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsuariosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DatabaseHelper(this);

        // Salvar Usuário
        binding.btnSalvarUsuario.setOnClickListener(v -> {
            String nome = binding.etNomeUsuario.getText().toString();
            String email = binding.etEmailUsuario.getText().toString();
            if (!nome.isEmpty() && !email.isEmpty()) {
                dbHelper.getWritableDatabase().execSQL("INSERT INTO Usuario (nome, email) VALUES (?, ?)",
                        new Object[]{nome, email});
                Toast.makeText(this, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Remover Usuário
        binding.btnRemoverUsuario.setOnClickListener(v -> {
            String email = binding.etEmailUsuario.getText().toString();
            dbHelper.getWritableDatabase().execSQL("DELETE FROM Usuario WHERE email = ?", new Object[]{email});
            Toast.makeText(this, "Usuário removido!", Toast.LENGTH_SHORT).show();
        });
    }
}
