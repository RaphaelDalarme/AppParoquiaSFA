package com.example.appparoquiasfa;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Evento {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;
    public String descricao;
    public String data;
    public String local;
}