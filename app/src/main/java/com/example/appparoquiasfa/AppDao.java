package com.example.appparoquiasfa;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppDao {

    @Query("SELECT * FROM Usuario WHERE email = :email AND senha = :senha LIMIT 1")
    Usuario fazerLogin(String email, String senha);

    @Insert
    void inserirUsuario(Usuario usuario);

    @Insert
    void inserirEvento(Evento evento);

    @Query("SELECT * FROM Evento ORDER BY id DESC")
    List<Evento> obterTodosEventos();
}