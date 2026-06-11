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

public class ConfissoesActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TextView btnVoltar;
    private final String[] titulosAbas = {"Exame de Consciência", "Como se Confessar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confissoes);

        tabLayout = findViewById(R.id.tabLayoutConfissoes);
        viewPager = findViewById(R.id.viewPagerConfissoes);
        btnVoltar = findViewById(R.id.btnVoltarConfissoes);

        btnVoltar.setOnClickListener(v -> finish());
        viewPager.setAdapter(new ConfissaoPagerAdapter());

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                tab.setText(titulosAbas[position])
        ).attach();
    }

    private class ConfissaoPagerAdapter extends RecyclerView.Adapter<ConfissaoPagerAdapter.ConfissaoViewHolder> {

        @NonNull
        @Override
        public ConfissaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aba_confissao, parent, false);
            return new ConfissaoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ConfissaoViewHolder holder, int position) {
            holder.container.removeAllViews();

            if (position == 0) {
                adicionarTextoIntro(holder.container, "Antes de iniciar, silencie o seu coração e faça uma breve oração:\n\n\"Vinde, Espírito Santo, iluminai a minha mente e a minha memória para que eu possa enxergar claramente todos os meus pecados, concedei-me um arrependimento sincero e a coragem de confessá-los com humildade. Amém.\"");

                adicionarSecao(holder.container, "1. Minha Relação com Deus");
                adicionarPergunta(holder.container, "Tenho rezado diariamente com sinceridade ou vivo esquecendo-me de Deus em minha rotina?");
                adicionarPergunta(holder.container, "Busco a Deus apenas quando preciso de algo ou quando estou in dificuldades?");
                adicionarPergunta(holder.container, "Alimentei dúvidas voluntárias sobre a bondade de Deus, guardando revolta ou ressentimento contra Ele?");
                adicionarPergunta(holder.container, "Sinto vergonha ou receio de demonstrar publicamente a minha fé cristã?");
                adicionarPergunta(holder.container, "Faltei à Santa Missa aos domingos ou dias de preceito por desleixo ou sem um motivo verdadeiramente grave?");
                adicionarPergunta(holder.container, "Durante as celebrações, permito-me distrações voluntárias, uso do celular ou falta de reverência no templo?");
                adicionarPergunta(holder.container, "Aproximei-me da Sagrada Comunhão estando em estado de pecado mortal?");
                adicionarPergunta(holder.container, "Há quanto tempo não procuro sinceramente o sacramento da confissão?");
                adicionarPergunta(holder.container, "Busco uma conversão autêntica de coração ou busco apenas manter as aparências de uma pessoa religiosa?");
                adicionarPergunta(holder.container, "Blasfemei, usei o santo nome de Deus sem o devido respeito ou fiz piadas com coisas sagradas?");
                adicionarPergunta(holder.container, "Recorri a práticas contrárias à fé cristã, como horóscopos, signos, tarô, simpatias, superstições ou ocultismo?");
                adicionarPergunta(holder.container, "Tenho colocado bens materiais, carreira, vaidade, relacionamentos ou redes sociais acima do amor a Deus?");
                adicionarPergunta(holder.container, "Tenho correspondido generosamente à minha vocação e ao chamado universal à santidade?");

                adicionarSecao(holder.container, "2. Pureza e Sexualidade");
                adicionarPergunta(holder.container, "Consumi conteúdos pornográficos ou preocupei-me em buscar imagens e perfis sensuais na internet?");
                adicionarPergunta(holder.container, "Cometi atos de impureza consigo mesmo (masturbação)?");
                adicionarPergunta(holder.container, "Alimentei pensamentos ou fantasias sexuais deliberadamente impuros?");
                adicionarPergunta(holder.container, "Flertei ou alimentei conversas ambíguas apenas por vaidade, carência ou para despertar o desejo alheio?");
                adicionarPergunta(holder.container, "Tratei alguma pessoa como um objeto de prazer, desrespeitando sua dignidade?");
                adicionarPergunta(holder.container, "Participei de conversas vulgares ou fiz piadas de duplo sentido de cunho sexual?");
                adicionarPergunta(holder.container, "Assisti a conteúdos ou ouvi músicas que estimulam e banalizam o pecado da impureza?");
                adicionarPergunta(holder.container, "Tive atitudes físicas ou carícias afetivas que ultrapassaram os limites da castidade e da moralidade?");
                adicionarPergunta(holder.container, "Tenho sido fiel à virtude da castidade de acordo com o meu estado de vida atual?");
                adicionarPergunta(holder.container, "Olhei para os outros com malícia ou desejo desordenado?");

                adicionarSecao(holder.container, "3. Orgulho e Vaidade");
                adicionarPergunta(holder.container, "Alimento uma necessidade excessiva de ser elogiado, admirado ou aprovado pelos outros?");
                adicionarPergunta(holder.container, "Sinto-me superior aos outros do ponto de vista espiritual, intelectual, moral ou social?");
                adicionarPergunta(holder.container, "Julgo o próximo com dureza, sem exercer a misericórdia e a compreensão?");
                adicionarPergunta(holder.container, "Alimentei inveja ou desgosto diante do sucesso, das conquistas ou da aparência de outra pessoa?");
                adicionarPergunta(holder.container, "Senti uma satisfação secreta ou prazer quando alguém falhou ou passou por dificuldades?");
                adicionarPergunta(holder.container, "Meu orgulho me impede de reconhecer meus erros e de pedir perdão de forma sincera?");
                adicionarPergunta(holder.container, "Sou arrogante, teimoso ou agressivo em discussões, querendo impor minha opinião a todo custo?");
                adicionarPergunta(holder.container, "Busco curtidas, validação virtual e atenção excessiva nas redes sociais para massagear meu ego?");
                adicionarPergunta(holder.container, "Dedico um tempo ou dinheiro desproporcional à vaidade com meu corpo e imagem pessoal?");

                adicionarSecao(holder.container, "4. Ira e Falta de Caridade");
                adicionarPergunta(holder.container, "Perco a paciência e explodo em acessos de ira com facilidade?");
                adicionarPergunta(holder.container, "Guardo mágoas, ressentimentos ou o desejo de vingança em meu coração?");
                adicionarPergunta(holder.container, "Desejei o mal de alguém ou roguei pragas em momentos de raiva?");
                adicionarPergunta(holder.container, "Tratei com frieza, grosseria ou desrespeito meus pais, familiares, amigos ou colegas?");
                adicionarPergunta(holder.container, "Fico alimentando discussões e brigas imaginárias em minha mente?");
                adicionarPergunta(holder.container, "Fui indiferente ou negligente diante do sofrimento espiritual ou material dos que me cercam?");

                adicionarSecao(holder.container, "5. Mentiras e Uso da Língua");
                adicionarPergunta(holder.container, "Menti ou omiti fatos importantes para obter vantagens ou para me proteger à custa da verdade?");
                adicionarPergunta(holder.container, "Participei de fofocas, espalhei boatos ou difamei a reputação de alguém?");
                adicionarPergunta(holder.container, "Falei mal de terceiros pelas costas, revelando defeitos alheios sem real necessidade?");
                adicionarPergunta(holder.container, "Aumentei histórias ou fui falso com as pessoas, fingindo uma amizade que não sinto?");
                adicionarPergunta(holder.container, "Faço uso frequente de palavrões, termos vulgares ou comentários destrutivos na internet?");
                adicionarPergunta(holder.container, "Prometi coisas sabendo de antemão que não iria cumpri-las, ou manipulei pessoas com minhas palavras?");

                adicionarSecao(holder.container, "6. Preguiça e Negligência");
                adicionarPergunta(holder.container, "Tenho desperdiçado meu tempo livre de forma descontrolada em redes sociais, jogos ou distrações vazias?");
                adicionarPergunta(holder.container, "Procrastino e deixo de cumprir com dedicação meus deveres de estado (estudos, trabalho, obrigações do lar)?");
                adicionarPergunta(holder.container, "Fujo dos sacrifícios diários, agindo com tibieza e mornidão em minha vida de oração?");
                adicionarPergunta(holder.container, "Tenho cuidado mal da minha saúde, do meu sono ou do meu corpo por puro desleixo?");

                adicionarSecao(holder.container, "7. Dinheiro e Honestidade");
                adicionarPergunta(holder.container, "Fui desonesto em exames acadêmicos, negócios ou peguei algo que não me pertencia?");
                adicionarPergunta(holder.container, "Enganei alguém financeiramente, abusei da boa-fé dos outros ou retenho o que é de direito alheio?");
                adicionarPergunta(holder.container, "Consumo pirataria ou busco caminhos ilícitos de forma egoísta e irresponsável?");
                adicionarPergunta(holder.container, "Sou dominado pela ganância, vivendo unicamente em função do dinheiro e dos bens materiais?");

                adicionarSecao(holder.container, "8. Relacionamentos");
                adicionarPergunta(holder.container, "Manipulo psicologicamente ou emocionalmente as pessoas para conseguir o que quero?");
                adicionarPergunta(holder.container, "Trato meus pais com a devida honra, respeito, gratidão e auxílio que eles necessitam?");
                adicionarPergunta(holder.container, "Tenho sido um bom amigo, impulsionando os outros para o bem e para a virtude, ou os incentivo ao pecado?");

                adicionarSecao(holder.container, "9. Para uma Reflexão Profunda");
                adicionarPergunta(holder.container, "Tenho combatido meus pecados de verdade ou fujo das ocasiões que me fazem cair?");
                adicionarPergunta(holder.container, "Qual é o pecado que eu mais tento justificar ou esconder de mí mesmo?");
                adicionarPergunta(holder.container, "Existe algum hábito ou apego que eu sei que me afasta de Deus, mas ainda insisto em escolher?");

            } else {
                // --- ABA 2: COMO SE CONFESSAR + HORÁRIOS ---
                adicionarSecao(holder.container, "📍 Horários de Atendimento");

                adicionarCardHorario(holder.container, "Terça-Feira", "• Antes da missa na Capela");
                adicionarCardHorario(holder.container, "Quinta-Feira", "• Antes da missa na Paróquia");
                adicionarCardHorario(holder.container, "Sábado", "• Após a missa da Paróquia");

                adicionarSecao(holder.container, "🙏 Roteiro do Confessionário");
                adicionarTextoIntro(holder.container, "Siga este passo a passo simples quando entrar na sala de confissão:");

                adicionarCardInstrucao(holder.container, "1. A Saudação", "Aproxime-se do sacerdote com humildade. Você pode fazer o sinal da cruz e dizer:\n\n\"Abençoai-me, padre, porque pequei. Minha última confissão foi há (diga o tempo aproximado).\"");
                adicionarCardInstrucao(holder.container, "2. A Acusação dos Pecados", "Diga seus pecados de forma clara, direta e honesta, começando por aqueles que mais pesam na consciência. Não tenha medo, o padre está ali em nome da misericórdia divina.\n\nTermine dizendo: \"Para estes e todos os pecados que não me recordo, peço o perdão de Deus e a absolvição do senhor.\"");
                adicionarCardInstrucao(holder.container, "3. O Conselho e a Penitência", "O sacerdote lhe dará uma palavra de orientação espiritual e indicará uma penitência (geralmente algumas orações ou uma ação de caridade). Ouça com atenção.");
                adicionarCardInstrucao(holder.container, "4. O Ato de Contrição", "O padre pedirá que você reze o Ato de Contrição. Reze com o coração:\n\n\"Senhor Jesus Cristo, Deus e homem verdadeiro, Criador e Redentor meu, por serdes Vós quem sois, sumamente bom e digno de ser amado sobre todas as coisas, e porque Vos amo e Vos estimo, pesa-me, Senhor, de todo o meu coração, de Vos ter ofendido. Proponho firmemente, com o auxílio de Vossa divina graça, emendar-me e nunca mais Vos tornar a ofender. Amém.\"");
                adicionarCardInstrucao(holder.container, "5. A Absolvição", "O padre estenderá as mãos e proferirá as palavras da absolvição. Ao final, quando ele disser \"...Eu te absolvo dos teus pecados em nome do Pai, e do Filho e do Espírito Santo\", faça o sinal da cruz e responda:\n\n\"Amém!\"");
                adicionarCardInstrucao(holder.container, "6. Despedida e Cumprimento", "O sacerdote dirá: \"Louvai ao Senhor porque Ele é bom.\" Você responde:\n\n\"Porque a sua misericórdia dura para sempre. Obrigado, padre.\" Vá em paz e cumpra sua penitência logo em seguida.");
            }
        }

        @Override
        public int getItemCount() {
            return titulosAbas.length;
        }

        private void adicionarTextoIntro(LinearLayout container, String texto) {
            TextView tv = new TextView(ConfissoesActivity.this);
            tv.setText(texto);
            tv.setTextSize(15);
            tv.setTextColor(getResources().getColor(R.color.texto_secundario));
            tv.setLineSpacing(4, 1);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            p.setMargins(0, 4, 0, 16);
            tv.setLayoutParams(p);
            container.addView(tv);
        }

        private void adicionarSecao(LinearLayout container, String titulo) {
            TextView tv = new TextView(ConfissoesActivity.this);
            tv.setText(titulo);
            tv.setTextSize(17);
            tv.setTypeface(null, android.graphics.Typeface.BOLD);
            tv.setTextColor(getResources().getColor(R.color.principal_marrom_escuro));
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            p.setMargins(0, 20, 0, 10);
            tv.setLayoutParams(p);
            container.addView(tv);
        }

        private void adicionarPergunta(LinearLayout container, String pergunta) {
            CardView card = new CardView(ConfissoesActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 4, 0, 6);
            card.setLayoutParams(params);
            card.setRadius(dpToPx(12));
            card.setCardElevation(0);
            card.setCardBackgroundColor(getResources().getColor(R.color.card_branco));

            TextView tv = new TextView(ConfissoesActivity.this);
            tv.setText(pergunta);
            tv.setTextSize(15);
            tv.setTextColor(getResources().getColor(R.color.texto_escuro));
            tv.setPadding(dpToPx(16), dpToPx(14), dpToPx(16), dpToPx(14));
            tv.setLineSpacing(3, 1);

            card.addView(tv);
            container.addView(card);

            card.setOnClickListener(v -> {
                boolean marcado = card.getTag() != null && (boolean) card.getTag();
                if (!marcado) {
                    card.setTag(true);
                    card.setCardBackgroundColor(getResources().getColor(R.color.fundo_app));
                    tv.setTextColor(getResources().getColor(R.color.principal_laranja_botoes));
                    tv.setTypeface(null, android.graphics.Typeface.BOLD);
                } else {
                    card.setTag(false);
                    card.setCardBackgroundColor(getResources().getColor(R.color.card_branco));
                    tv.setTextColor(getResources().getColor(R.color.texto_escuro));
                    tv.setTypeface(null, android.graphics.Typeface.NORMAL);
                }
            });
        }

        private void adicionarCardHorario(LinearLayout container, String dia, String info) {
            CardView card = new CardView(ConfissoesActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 4, 0, 8);
            card.setLayoutParams(params);
            card.setRadius(dpToPx(12));
            card.setCardElevation(0);
            card.setCardBackgroundColor(getResources().getColor(R.color.card_branco));

            LinearLayout layout = new LinearLayout(ConfissoesActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setPadding(dpToPx(16), dpToPx(14), dpToPx(16), dpToPx(14));

            TextView tvDia = new TextView(ConfissoesActivity.this);
            tvDia.setText(dia);
            tvDia.setTextSize(16);
            tvDia.setTypeface(null, android.graphics.Typeface.BOLD);
            tvDia.setTextColor(getResources().getColor(R.color.texto_escuro));

            TextView tvInfo = new TextView(ConfissoesActivity.this);
            tvInfo.setText(info);
            tvInfo.setTextSize(14);
            tvInfo.setTextColor(getResources().getColor(R.color.texto_secundario));
            LinearLayout.LayoutParams pText = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            pText.setMargins(0, 4, 0, 0);
            tvInfo.setLayoutParams(pText);

            layout.addView(tvDia);
            layout.addView(tvInfo);
            card.addView(layout);
            container.addView(card);
        }

        private void adicionarCardInstrucao(LinearLayout container, String passo, String detalhes) {
            CardView card = new CardView(ConfissoesActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 6, 0, 10);
            card.setLayoutParams(params);
            card.setRadius(dpToPx(16));
            card.setCardElevation(0);
            card.setCardBackgroundColor(getResources().getColor(R.color.card_branco));

            LinearLayout layout = new LinearLayout(ConfissoesActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setPadding(dpToPx(18), dpToPx(16), dpToPx(18), dpToPx(16));

            TextView tvPasso = new TextView(ConfissoesActivity.this);
            tvPasso.setText(passo);
            tvPasso.setTextSize(16);
            tvPasso.setTypeface(null, android.graphics.Typeface.BOLD);
            tvPasso.setTextColor(getResources().getColor(R.color.principal_laranja_botoes));

            TextView tvDet = new TextView(ConfissoesActivity.this);
            tvDet.setText(detalhes);
            tvDet.setTextSize(14);
            tvDet.setTextColor(getResources().getColor(R.color.texto_escuro));
            tvDet.setLineSpacing(4, 1);
            LinearLayout.LayoutParams pText = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            pText.setMargins(0, 6, 0, 0);
            tvDet.setLayoutParams(pText);

            layout.addView(tvPasso);
            layout.addView(tvDet);
            card.addView(layout);
            container.addView(card);
        }

        private int dpToPx(int dp) {
            return Math.round((float) dp * getResources().getDisplayMetrics().density);
        }

        class ConfissaoViewHolder extends RecyclerView.ViewHolder {
            LinearLayout container;
            ConfissaoViewHolder(@NonNull View itemView) {
                super(itemView);
                container = itemView.findViewById(R.id.containerConfissao);
            }
        }
    }
}