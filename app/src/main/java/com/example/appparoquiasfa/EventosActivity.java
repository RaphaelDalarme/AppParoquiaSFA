package com.example.appparoquiasfa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;

public class EventosActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TextView btnVoltar;
    private final String[] titulosAbas = {"Especiais", "Terço", "Oração", "Movimentos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        tabLayout = findViewById(R.id.tabLayoutEventos);
        viewPager = findViewById(R.id.viewPagerEventos);
        btnVoltar = findViewById(R.id.btnVoltarEventos);

        btnVoltar.setOnClickListener(v -> finish());

        viewPager.setAdapter(new EventosPagerAdapter());

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                tab.setText(titulosAbas[position])
        ).attach();
    }

    private class EventosPagerAdapter extends RecyclerView.Adapter<EventosPagerAdapter.EventosViewHolder> {

        @NonNull
        @Override
        public EventosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_eventos, parent, false);
            return new EventosViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EventosViewHolder holder, int position) {
            holder.container.removeAllViews();

            if (position == 0) {

                adicionarCard(holder.container, "Confecção do Tapete de Corpus Christi",
                        "Data: 03 de Junho\nHorário: 19h30\nLocal: Matriz\n\nVenha ajudar a nossa comunidade a preparar os tapetes para a grande celebração do dia seguinte! Traga a sua família para este momento de união.");

                adicionarCard(holder.container, "Missa de Corpus Christi",
                        "Data: 04 de Junho\nLocal: Matriz\n\nParticipe da Solenidade do Santíssimo Corpo e Sangue de Cristo. Uma das celebrações mais importantes da nossa Igreja, com a tradicional procissão sobre os tapetes.");

                adicionarCard(holder.container, "Encontro dos Namorados",
                        "Data: 13 de Junho\nLocal: Paróquia\n\nUm momento especial dedicado aos casais de namorados da nossa comunidade para fortalecer o amor, a cumplicidade e a fé sob a bênção de Deus.");

                adicionarCard(holder.container, "Momento de Espiritualidade • Ministério de Artes",
                        "Data: 14 de Junho\nLocal: Paróquia\n\nUma manhã/tarde especial reservada para a oração, reflexão e abastecimento espiritual de todos os membros e servos do Ministério de Artes.");
            } else if (position == 1) {
                // ABA 1: Conteúdo do Terço
                adicionarCard(holder.container, "Segunda-feira", "19h30 - Terço dos Homens\nMatriz e Capela");
                adicionarCard(holder.container, "Terça-feira", "15h00 - Terço da Misericórdia\nMatriz");
                adicionarCard(holder.container, "Quarta-feira", "19h30 - Terço das Mulheres\nCapela");
                adicionarCard(holder.container, "Quinta-feira", "15h00 - Terço da Misericórdia\nCapela");
                adicionarCard(holder.container, "Sexta-feira", "16h00 - Terço do Apostolado • Capela\n18h30 - Terço das Mulheres • Matriz");
                adicionarCard(holder.container, "3º Segunda do Mês", "19h30 - Terço Glorioso São José\nCapela");

            } else if (position == 2) {
                // ABA 2: Conteúdo do Grupo de Oração
                adicionarCard(holder.container, "Quarta-feira", "19h00 às 21h00 - Núcleo de Oração\nSala Santa Clara\n\n19h30 - Grupo de Oração\nMatriz");
                adicionarCard(holder.container, "Quinta-feira", "19h30 - Grupo de Oração\nCapela");
                adicionarCard(holder.container, "Domingo", "19h30 - Ministério Jovem\nSalão Paroquial");

            } else {
                // ABA 3: Conteúdo dos Movimentos Pastorais (Imagem WhatsApp)
                adicionarCard(holder.container, "2º Domingo do Mês", "09h00 às 12h00 - Reunião Pastoral Familiar\nSala Santa Clara");
                adicionarCard(holder.container, "3º Domingo do Mês", "10h00 às 15h00 - Campanha do Quilo\nSalão da Matriz");
                adicionarCard(holder.container, "Sexta-feira", "08h00 às 12h00 - Bazar (Centro Pastoral)\n14h00 às 17h00 - Bazar (Capela)\n14h00 às 17h00 - Aula de Artesanato (Centro Pastoral)");
                adicionarCard(holder.container, "Sábado", "08h00 - Catequese Infantil (Salas da Matriz e Capela)\n08h40 - Ofício de Nossa Senhora (Matriz)");
            }
        }

        @Override
        public int getItemCount() {
            return titulosAbas.length;
        }

        private void adicionarCard(LinearLayout container, String dia, String informacoes) {
            CardView cardView = new CardView(EventosActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, dpToPx(14));
            cardView.setLayoutParams(params);
            cardView.setRadius(dpToPx(16));
            cardView.setCardElevation(0);
            cardView.setCardBackgroundColor(getResources().getColor(R.color.card_branco));

            LinearLayout layoutInterno = new LinearLayout(EventosActivity.this);
            layoutInterno.setOrientation(LinearLayout.VERTICAL);
            layoutInterno.setPadding(dpToPx(18), dpToPx(16), dpToPx(18), dpToPx(16));

            TextView tvDia = new TextView(EventosActivity.this);
            tvDia.setText(dia);
            tvDia.setTextSize(16);
            tvDia.setTypeface(null, android.graphics.Typeface.BOLD);
            tvDia.setTextColor(getResources().getColor(R.color.texto_escuro));

            TextView tvInfo = new TextView(EventosActivity.this);
            tvInfo.setText(informacoes);
            tvInfo.setTextSize(14);
            tvInfo.setTextColor(getResources().getColor(R.color.texto_secundario));
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textParams.setMargins(0, dpToPx(6), 0, 0);
            tvInfo.setLayoutParams(textParams);

            layoutInterno.addView(tvDia);
            layoutInterno.addView(tvInfo);
            cardView.addView(layoutInterno);
            container.addView(cardView);
        }

        private int dpToPx(int dp) {
            float density = getResources().getDisplayMetrics().density;
            return Math.round((float) dp * density);
        }

        class EventosViewHolder extends RecyclerView.ViewHolder {
            LinearLayout container;
            EventosViewHolder(@NonNull View itemView) {
                super(itemView);
                container = itemView.findViewById(R.id.containerCardsEventos);
            }
        }
    }
}