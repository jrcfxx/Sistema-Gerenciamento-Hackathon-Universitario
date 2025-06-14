/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Empresa extends Instituicao {

    private String ramo;

    public Empresa(String nome, String sigla, String cidade, String estado, String ramo) {
        super(nome, sigla, cidade, estado);
        this.ramo = ramo;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}
