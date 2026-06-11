package com.example.appparoquiasfa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etEmail, etSenha;
    private MaterialButton btnEntrar;
    private TextView tvCadastrese;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = AppDatabase.getInstance(this);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        tvCadastrese = findViewById(R.id.tvCadastrese);
        new Thread(new Runnable() {
            @Override
            public void run() {

                Usuario admin = db.appDao().fazerLogin("pascom@email.com", "1234");
                if (admin == null) {

                    Usuario novoAdmin = new Usuario();
                    novoAdmin.nome = "Administrador PASCOM";
                    novoAdmin.email = "pascom@email.com";
                    novoAdmin.senha = "1234";
                    novoAdmin.perfil = "ADMIN"; // Este tem super poderes no app

                    db.appDao().inserirUsuario(novoAdmin);
                }
            }
        }).start();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();

                if (email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Usuario usuarioLogado = db.appDao().fazerLogin(email, senha);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (usuarioLogado != null) {
                                    Toast.makeText(LoginActivity.this, "Bem-vindo, " + usuarioLogado.nome + "!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("USER_EMAIL", usuarioLogado.email);
                                    intent.putExtra("USER_PERFIL", usuarioLogado.perfil);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }).start();
            }
        });

        tvCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}