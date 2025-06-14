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
        if (jurados == null || jurados.isEmpty()) {
            System.out.println("Não há jurados para avaliar.");
            projetoAvaliado.setNotaFinal(0);
            return;
        }

        int somaNotas = jurados.values().stream().mapToInt(Integer::intValue).sum();
        int media = Math.round((float) somaNotas / jurados.size());

        projetoAvaliado.setNotaFinal(media);

        System.out.println("Nota final calculada para o projeto '" + projetoAvaliado.getTitulo() + "': " + media);
    }
}
