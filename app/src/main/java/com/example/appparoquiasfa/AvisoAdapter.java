package com.example.appparoquiasfa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AvisoAdapter extends RecyclerView.Adapter<AvisoAdapter.AvisoViewHolder> {

    private List<Aviso> listaAvisos;

    public AvisoAdapter(List<Aviso> listaAvisos) {
        this.listaAvisos = listaAvisos;
    }

    @NonNull
    @Override
    public AvisoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aviso, parent, false);
        return new AvisoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvisoViewHolder holder, int position) {
        Aviso aviso = listaAvisos.get(position);
        holder.txtTag.setText(aviso.getTag().toUpperCase());
        holder.txtTitulo.setText(aviso.getTitulo());
        holder.txtDescricao.setText(aviso.getDescricao());
        holder.txtDataHora.setText(aviso.getDataHora());
        holder.txtLocal.setText(aviso.getLocal());
    }

    @Override
    public int getItemCount() {
        return listaAvisos.size();
    }

    public static class AvisoViewHolder extends RecyclerView.ViewHolder {
        TextView txtTag, txtTitulo, txtDescricao, txtDataHora, txtLocal;

        public AvisoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTag = itemView.findViewById(R.id.txtTagAviso);
            txtTitulo = itemView.findViewById(R.id.txtTituloAviso);
            txtDescricao = itemView.findViewById(R.id.txtDescricaoAviso);
            txtDataHora = itemView.findViewById(R.id.txtDataHoraAviso);
            txtLocal = itemView.findViewById(R.id.txtLocalAviso);
        }
    }
}