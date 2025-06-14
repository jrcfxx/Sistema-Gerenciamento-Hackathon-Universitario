/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Sala {

    private String id;
    private int capacidade;
    private String localizacao;

    public Sala(String identificador, int capacidade, String localizacao) {
        this.id = identificador;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
    }

    public String getIdentificador() {
        return id;
    }

    public void setIdentificador(String identificador) {
        this.id = identificador;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
