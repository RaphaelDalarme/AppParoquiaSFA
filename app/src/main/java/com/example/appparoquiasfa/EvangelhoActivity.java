package com.example.appparoquiasfa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class EvangelhoActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ProgressBar progressBar;
    private TextView tvData, btnVoltar;

    private final ArrayList<String> titulosAbas = new ArrayList<>();
    private final ArrayList<LeituraModel> listaLeituras = new ArrayList<>();
    private LiturgiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evangelho);

        tabLayout = findViewById(R.id.tabLayoutLiturgia);
        viewPager = findViewById(R.id.viewPagerLiturgia);
        progressBar = findViewById(R.id.progressLiturgia);
        tvData = findViewById(R.id.tvDataLiturgia);
        btnVoltar = findViewById(R.id.btnVoltarLiturgia);

        btnVoltar.setOnClickListener(v -> finish());

        adapter = new LiturgiaAdapter();
        viewPager.setAdapter(adapter);

        buscarLiturgiaDoDia();
    }

    private void buscarLiturgiaDoDia() {
        progressBar.setVisibility(View.VISIBLE);

        final String urlApi = "https://liturgia.up.railway.app/";

        new Thread(() -> {
            try {
                URL url = new URL(urlApi);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");

                if (conexao.getResponseCode() == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                    StringBuilder resultado = new StringBuilder();
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        resultado.append(linha);
                    }
                    reader.close();

                    parsearDadosLiturgia(resultado.toString());
                } else {
                    mostrarErroNaUi();
                }
            } catch (Exception e) {
                mostrarErroNaUi();
            }
        }).start();
    }

    private void parsearDadosLiturgia(String jsonStr) {
        try {
            JSONObject json = new JSONObject(jsonStr);
            final String dataFormatada = json.optString("data", "Hoje");

            listaLeituras.clear();
            titulosAbas.clear();

            try {
                if (json.has("primeiraLeitura") && !json.isNull("primeiraLeitura")) {
                    JSONObject obj = json.getJSONObject("primeiraLeitura");
                    listaLeituras.add(new LeituraModel(
                            obj.optString("referencia", ""),
                            obj.optString("titulo", "1ª Leitura"),
                            obj.optString("texto", "")
                    ));
                    titulosAbas.add("1ª Leitura");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (json.has("salmo") && !json.isNull("salmo")) {
                    JSONObject obj = json.getJSONObject("salmo");
                    // A API às vezes usa 'refrao' ou 'titulo' para o Salmo, tratamos as duas opções:
                    String tituloSalmo = obj.has("refrao") ? obj.optString("refrao") : obj.optString("titulo", "Salmo Responsorial");
                    listaLeituras.add(new LeituraModel(
                            obj.optString("referencia", ""),
                            tituloSalmo,
                            obj.optString("texto", "")
                    ));
                    titulosAbas.add("Salmo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (json.has("segundaLeitura") && !json.isNull("segundaLeitura")) {
                    JSONObject obj = json.getJSONObject("segundaLeitura");
                    listaLeituras.add(new LeituraModel(
                            obj.optString("referencia", ""),
                            obj.optString("titulo", "2ª Leitura"),
                            obj.optString("texto", "")
                    ));
                    titulosAbas.add("2ª Leitura");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (json.has("evangelho") && !json.isNull("evangelho")) {
                    JSONObject obj = json.getJSONObject("evangelho");
                    listaLeituras.add(new LeituraModel(
                            obj.optString("referencia", ""),
                            obj.optString("titulo", "Evangelho"),
                            obj.optString("texto", "")
                    ));
                    titulosAbas.add("Evangelho");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                tvData.setText(dataFormatada);

                if (!listaLeituras.isEmpty()) {
                    adapter.notifyDataSetChanged();

                    new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                            tab.setText(titulosAbas.get(position))
                    ).attach();
                } else {
                    tvData.setText("Disponível offline na Igreja");
                    Toast.makeText(EvangelhoActivity.this, "Nenhuma leitura disponível para hoje.", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            runOnUiThread(() -> {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(EvangelhoActivity.this, "Erro ao processar o formato da liturgia.", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private void mostrarErroNaUi() {
        runOnUiThread(() -> {
            progressBar.setVisibility(View.GONE);
            tvData.setText("Disponível offline na Igreja");
            Toast.makeText(EvangelhoActivity.this, "Erro ao atualizar leituras. Verifique sua conexão.", Toast.LENGTH_SHORT).show();
        });
    }

    private static class LeituraModel {
        String referencia, titulo, texto;
        LeituraModel(String ref, String tit, String txt) {
            this.referencia = ref;
            this.titulo = tit;
            this.texto = txt;
        }
    }

    private class LiturgiaAdapter extends RecyclerView.Adapter<LiturgiaAdapter.LiturgiaViewHolder> {

        @NonNull
        @Override
        public LiturgiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leitura_liturgia, parent, false);
            return new LiturgiaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull LiturgiaViewHolder holder, int position) {
            LeituraModel leitura = listaLeituras.get(position);
            holder.tvRef.setText(leitura.referencia);
            holder.tvTitulo.setText(leitura.titulo);
            holder.tvTexto.setText(leitura.texto);
        }

        @Override
        public int getItemCount() {
            return listaLeituras.size();
        }

        class LiturgiaViewHolder extends RecyclerView.ViewHolder {
            TextView tvRef, tvTitulo, tvTexto;
            LiturgiaViewHolder(@NonNull View itemView) {
                super(itemView);
                tvRef = itemView.findViewById(R.id.tvRefLeitura);
                tvTitulo = itemView.findViewById(R.id.tvTituloLeitura);
                tvTexto = itemView.findViewById(R.id.tvTextoLeitura);
            }
        }
    }
}