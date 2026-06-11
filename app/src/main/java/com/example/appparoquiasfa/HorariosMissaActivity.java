package com.example.appparoquiasfa;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HorariosMissaActivity extends AppCompatActivity {

    private TextView btnVoltarMissa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_missa);

        btnVoltarMissa = findViewById(R.id.btnVoltarMissa);

        btnVoltarMissa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha esta tela e volta para a MainActivity automaticamente!
            }
        });
    }
}