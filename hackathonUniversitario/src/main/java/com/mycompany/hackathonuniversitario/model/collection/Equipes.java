/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model.collection;

import com.mycompany.hackathonuniversitario.model.Equipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class Equipes {

    private static Equipes instancia;
    private List<Equipe> listaEquipes;

    private Equipes() {
        listaEquipes = new ArrayList<>();
    }

    public static Equipes getInstancia() {
        /*
         * [CODE REVIEW #15 - Singleton thread-safety]
         * Lazy initialization sem sincronizacao. Em ambiente multithread, duas
         * instancias podem ser criadas. Sugestao: Initialization-on-demand holder idiom.
         * Mesmo problema em Apresentacoes, Projetos, Bancas e Salas.
         */
        if (instancia == null) {
            instancia = new Equipes();
        }
        return instancia;
    }

    public void adicionarEquipe(Equipe equipe) {
        listaEquipes.add(equipe);
    }

    public Equipe buscarPorNome(String nome) {
        /*
         * [CODE REVIEW #16 - Retorno nulo]
         * Retorna null quando nao encontra. Sugestao: usar Optional<Equipe> como
         * ja feito em Salas.buscarPorId() para evitar NullPointerException.
         */
        return listaEquipes.stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    /*
     * [CODE REVIEW #17 - Vazamento de encapsulamento]
     * Retorna referencia direta da lista interna. Codigo externo pode alterar
     * sem passar por adicionarEquipe(). Sugestao: Collections.unmodifiableList().
     */
    public List<Equipe> getTodasEquipes() {
        return listaEquipes;
    }
}
