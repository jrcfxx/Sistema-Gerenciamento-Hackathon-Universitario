/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class Instituicao {

    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private List<Equipe> equipes;

    public Instituicao(String nome, String sigla, String cidade, String estado) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.equipes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void adicionarEquipe(Equipe equipe) {
        equipes.add(equipe);
    }
}
