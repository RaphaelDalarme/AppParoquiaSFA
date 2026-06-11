package com.example.appparoquiasfa;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CriarEventoActivity extends AppCompatActivity {

    private TextInputEditText etEvTitulo, etEvDesc, etEvData, etEvLocal;
    private MaterialButton btnSalvarEvento;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_evento);

        db = AppDatabase.getInstance(this);

        etEvTitulo = findViewById(R.id.etEvTitulo);
        etEvDesc = findViewById(R.id.etEvDesc);
        etEvData = findViewById(R.id.etEvData);
        etEvLocal = findViewById(R.id.etEvLocal);
        btnSalvarEvento = findViewById(R.id.btnSalvarEvento);

        btnSalvarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = etEvTitulo.getText().toString().trim();
                String desc = etEvDesc.getText().toString().trim();
                String data = etEvData.getText().toString().trim();
                String local = etEvLocal.getText().toString().trim();

                if (titulo.isEmpty() || desc.isEmpty() || data.isEmpty() || local.isEmpty()) {
                    Toast.makeText(CriarEventoActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Evento novoEvento = new Evento();
                        novoEvento.titulo = titulo;
                        novoEvento.descricao = desc;
                        novoEvento.data = data;
                        novoEvento.local = local;

                        db.appDao().inserirEvento(novoEvento);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(CriarEventoActivity.this, "Evento criado com sucesso!", Toast.LENGTH_SHORT).show();
                                finish(); // Fecha e volta para a tela anterior
                            }
                        });
                    }
                }).start();
            }
        });
    }
}