/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model.collection;

import com.mycompany.hackathonuniversitario.model.Banca;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Júlia
 */
public class Bancas {

    private static Bancas instancia;
    private List<Banca> listaBancas;

    private Bancas() {
        listaBancas = new ArrayList<>();
    }

    public static Bancas getInstancia() {
        if (instancia == null) {
            instancia = new Bancas();
        }
        return instancia;
    }

    public void adicionarBanca(Banca banca) {
        listaBancas.add(banca);
    }

    public List<Banca> getTodasBancas() {
        return listaBancas;
    }

    public List<Banca> buscarPorProjeto(String tituloProjeto) {
        return listaBancas.stream()
                .filter(b -> b.getProjetoAvaliado().getTitulo().equalsIgnoreCase(tituloProjeto))
                .collect(Collectors.toList());
    }
}
