package com.example.appparoquiasfa;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "avisos")
public class Aviso {

    @PrimaryKey(autoGenerate = true)
    public int id_aviso;

    public String tag;
    public String titulo;
    public String descricao;
    public String dataHora;
    public String local;

    public Aviso() {
    }

    @Ignore
    public Aviso(String tag, String titulo, String descricao, String dataHora, String local) {
        this.tag = tag;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
    }


    public String getTag() { return tag; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getDataHora() { return dataHora; }
    public String getLocal() { return local; }
}