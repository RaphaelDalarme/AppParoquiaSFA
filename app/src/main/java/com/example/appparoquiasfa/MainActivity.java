package com.example.appparoquiasfa;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_missas) {
                    Intent intent = new Intent(MainActivity.this, HorariosMissaActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.nav_confissoes) {
                    Intent intent = new Intent(MainActivity.this, ConfissoesActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.nav_eventos) {
                    Intent intent = new Intent(MainActivity.this, EventosActivity.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.nav_evangelho) {
                    Intent intent = new Intent(MainActivity.this, EvangelhoActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        RecyclerView rvCarrosselAvisos = findViewById(R.id.rvCarrosselAvisos);
        rvCarrosselAvisos.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        List<Aviso> listaAvisos = new ArrayList<>();

        listaAvisos.add(new Aviso(
                "Solenidade",
                "Corpus Christi",
                "Participe da profunda adoração comunitária. Ambos os horários contarão com procissão no final. Traga sua vela para a celebração da noite!",
                "04/06 • 09h e 19h30",
                "Matriz e Capela"
        ));

        listaAvisos.add(new Aviso(
                "Casais",
                "Encontro de Namorados",
                "“Namoro: amar, discernir e caminhar para Deus”. Garanta sua vaga por apenas R$ 20 no balcão do dízimo ou via formulário online.",
                "13/06 • 15h",
                "Capela"
        ));

        listaAvisos.add(new Aviso(
                "Adoração",
                "Santíssimo Sacramento",
                "Terça-feira na Capela e Quinta-feira na Matriz. Venha vivenciar momentos de Adoração seguidos da Santa Missa.",
                "Ter e Qui • 18h30",
                "Matriz / Capela"
        ));

        listaAvisos.add(new Aviso(
                "Secretaria",
                "Atendimento Paroquial",
                "Para intenções de missa e documentos. Seg a Sex: 9h às 12h30 e 14h às 19h. Sáb: 8h às 14h.",
                "Seg a Sáb",
                "R. Missão Velha, 08"
        ));

        AvisoAdapter adapter = new AvisoAdapter(listaAvisos);
        rvCarrosselAvisos.setAdapter(adapter);

        Intent intentRecuperado = getIntent();
        String perfilLogado = intentRecuperado.getStringExtra("USER_PERFIL");

        Button btnAdicionarEvento = findViewById(R.id.btn_adicionar_evento);
        btnSair = findViewById(R.id.btnSair);

        if (perfilLogado != null && perfilLogado.equals("ADMIN")) {
            btnAdicionarEvento.setVisibility(View.VISIBLE);
        } else {
            btnAdicionarEvento.setVisibility(View.GONE);
        }

        btnAdicionarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CriarEventoActivity.class);
                startActivity(intent);
            }
        });

        if (btnSair != null) {
            btnSair.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, "Sessão encerrada!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}