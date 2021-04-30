package com.allin.sdainfo.tique.model;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Movimento {

    private String id;
    private List<String> listaValores;

    public Movimento() {
        DatabaseReference tabela = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_MOVIMENTO);
        setId(tabela.push().getKey());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getListaValores() {
        return listaValores;
    }

    public void setListaValores(List<String> listaValores) {
        this.listaValores = listaValores;
    }
}
