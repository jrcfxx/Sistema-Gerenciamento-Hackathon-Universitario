/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Pessoa {

    private String nome;
    private String cpf;
    private Instituicao instituicao;

    public Pessoa(String nome, String cpf, Instituicao instituicao) {
        this.nome = nome;
        this.cpf = cpf;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
