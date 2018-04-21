package com.example.a16254868.motoristaasteroide;

import java.io.Serializable;

public class Funcionario implements Serializable {

    int id = 0;
    String nome = "";
    String usuario = "";
    int ativo = 0;
    String cpf = "";
    String cnh = "";
    String email = "";
    String telefone = "";
    String celular = "";
    String rg = "";
    String sexo = "";
    String dataNasc = "";


    public Funcionario(){

    }

    public Funcionario(int id, String nome, String usuario, int ativo, String cpf, String cnh, String email, String telefone, String celular, String rg, String sexo, String dataNasc){

        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.ativo = ativo;
        this.cpf = cpf;
        this.cnh = cnh;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNasc = dataNasc;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}