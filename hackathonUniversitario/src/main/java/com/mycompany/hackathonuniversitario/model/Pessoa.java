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

    /*
     * [CODE REVIEW #18 - Validacao ausente]
     * Nao ha validacao de nome, cpf ou instituicao. CPFs invalidos sao aceitos.
     * Sugestao: validar no construtor e implementar equals/hashCode baseados no CPF
     * (necessario para uso correto em HashMap, ex.: Map<Jurado, Integer> em Banca).
     */
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
