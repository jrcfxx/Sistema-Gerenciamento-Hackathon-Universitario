/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Profissional extends Pessoa {

    private String areaDeAtuacao;

    public Profissional(String nome, String cpf, Instituicao instituicao, String areaDeAtuacao) {
        super(nome, cpf, instituicao);
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }
}
