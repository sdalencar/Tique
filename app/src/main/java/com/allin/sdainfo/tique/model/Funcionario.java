package com.allin.sdainfo.tique.model;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String id;
    private String nome;
    private String email;
    private String cargo;
    private String salario;
    private String contratado;
    private String demitido;
    private String nascimento;
    private String imagem;


    public Funcionario() {
        //tabela do banco de dados
        DatabaseReference tabela_funcionario = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_FUNCIONARIO);
        //id autoincrement
        setId(tabela_funcionario.push().getKey());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getContratado() {
        return contratado;
    }

    public void setContratado(String contratado) {
        this.contratado = contratado;
    }

    public String getDemitido() {
        return demitido;
    }

    public void setDemitido(String demitido) {
        this.demitido = demitido;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}