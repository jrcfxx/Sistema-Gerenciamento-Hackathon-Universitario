/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Projeto {

    private String titulo;
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(String titulo, Profissional orientador, Equipe equipe) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public Profissional getOrientador() {
        return orientador;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }
}
