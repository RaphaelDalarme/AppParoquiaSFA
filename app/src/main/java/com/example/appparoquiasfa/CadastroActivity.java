package com.example.appparoquiasfa;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText etCadNome, etCadEmail, etCadSenha;
    private MaterialButton btnSalvarCadastro;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        db = AppDatabase.getInstance(this);

        etCadNome = findViewById(R.id.etCadNome);
        etCadEmail = findViewById(R.id.etCadEmail);
        etCadSenha = findViewById(R.id.etCadSenha);
        btnSalvarCadastro = findViewById(R.id.btnSalvarCadastro);

        btnSalvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etCadNome.getText().toString().trim();
                String email = etCadEmail.getText().toString().trim();
                String senha = etCadSenha.getText().toString().trim();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Usuario novoUsuario = new Usuario();
                        novoUsuario.nome = nome;
                        novoUsuario.email = email;
                        novoUsuario.senha = senha;
                        novoUsuario.perfil = "LEITOR";

                        db.appDao().inserirUsuario(novoUsuario);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(CadastroActivity.this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}