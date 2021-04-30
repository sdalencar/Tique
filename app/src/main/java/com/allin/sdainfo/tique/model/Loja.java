package com.allin.sdainfo.tique.model;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class Loja implements Serializable {

    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String responsavel;


    public Loja() {
        DatabaseReference tabela_banco = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_NOME_LOJA);
        setId(tabela_banco.push().getKey());
    }

    public void salvarLojaDados() {
        DatabaseReference tabela_banco = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_NOME_LOJA).child(getId());
        tabela_banco.setValue(this);
    }

    public void satualizarLojaDados() {
        DatabaseReference tabela_banco = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_NOME_LOJA).child(getId());
        tabela_banco.setValue(this);
    }

    public void deletarNomeLoja(){
        String id_user = ConfigurarFirebase.getIdUsuario();
        DatabaseReference tb_nome_loja = ConfigurarFirebase.getBanco_dados()
                .child(Constantes.NOH_NOME_LOJA)
                .child(id_user)
                .child(getId());

        tb_nome_loja.removeValue();
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
