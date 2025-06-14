/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

import java.util.Map;

/**
 *
 * @author Júlia
 */
public class Banca implements Avaliavel {

    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados;

    public Banca(Projeto projetoAvaliado, Map<Jurado, Integer> jurados) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = jurados;
    }

    public Projeto getProjetoAvaliado() {
        return projetoAvaliado;
    }

    public Map<Jurado, Integer> getJurados() {
        return jurados;
    }

    @Override
    public void calcularNotaFinal() {
        System.out.println("calcularNotaFinal");
    }
}
