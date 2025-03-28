package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityProdutosBinding;

public class ProdutoActivity extends AppCompatActivity {

    private ActivityProdutosBinding binding;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProdutosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DatabaseHelper(this);

        // Salvar Produto
        binding.btnSalvarProduto.setOnClickListener(v -> {
            String nome = binding.etNomeProduto.getText().toString();
            String precoStr = binding.etPrecoProduto.getText().toString();
            if (!nome.isEmpty() && !precoStr.isEmpty()) {
                double preco = Double.parseDouble(precoStr);
                dbHelper.getWritableDatabase().execSQL("INSERT INTO Produto (nome, preco) VALUES (?, ?)",
                        new Object[]{nome, preco});
                Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });

        // Remover Produto
        binding.btnRemoverProduto.setOnClickListener(v -> {
            String nome = binding.etNomeProduto.getText().toString();
            dbHelper.getWritableDatabase().execSQL("DELETE FROM Produto WHERE nome = ?", new Object[]{nome});
            Toast.makeText(this, "Produto removido!", Toast.LENGTH_SHORT).show();
        });
    }
}
