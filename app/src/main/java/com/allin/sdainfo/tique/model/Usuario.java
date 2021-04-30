package com.allin.sdainfo.tique.model;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Usuario implements Serializable {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public Usuario() {
        DatabaseReference tabela = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_USUARIO);
        setId(tabela.push().getKey());
    }

    @Exclude
    public Map<String, Object> converterEmMap() {
        HashMap<String, Object> map_usuario = new HashMap<>();
        map_usuario.put(Constantes.NOME, getNome());
        map_usuario.put(Constantes.EMAIL, getEmail());
        map_usuario.put(Constantes.SENHA, getSenha());
        return map_usuario;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
