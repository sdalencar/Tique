package com.allin.sdainfo.tique.model;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String id;
    private String nome;
    private String apelido;
    private String telefone;

    public Cliente() {
        DatabaseReference tabela = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_PESSOA);
        setId(tabela.push().getKey());
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Exclude
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
