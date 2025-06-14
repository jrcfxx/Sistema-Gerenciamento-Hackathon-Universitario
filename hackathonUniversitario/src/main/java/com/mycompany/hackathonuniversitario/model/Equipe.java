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
public class Equipe {

    private String nome;
    private List<Estudante> membros;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getMembros() {
        return membros;
    }

    public void adicionarMembro(Estudante estudante) {
        membros.add(estudante);
    }
}
