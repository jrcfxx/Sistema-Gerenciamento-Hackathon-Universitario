/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model.collection;

import com.mycompany.hackathonuniversitario.model.Apresentacao;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class Apresentacoes {

    private static Apresentacoes instancia;
    private List<Apresentacao> listaApresentacoes;

    private Apresentacoes() {
        listaApresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstancia() {
        if (instancia == null) {
            instancia = new Apresentacoes();
        }
        return instancia;
    }

    public void adicionarApresentacao(Apresentacao apresentacao) {
        listaApresentacoes.add(apresentacao);
    }

    public List<Apresentacao> getTodasApresentacoes() {
        return listaApresentacoes;
    }

    public List<Apresentacao> buscarPorProjeto(String tituloProjeto) {
        return listaApresentacoes.stream()
                .filter(a -> a.getProjeto().getTitulo().equalsIgnoreCase(tituloProjeto))
                .collect(Collectors.toList());
    }
}
