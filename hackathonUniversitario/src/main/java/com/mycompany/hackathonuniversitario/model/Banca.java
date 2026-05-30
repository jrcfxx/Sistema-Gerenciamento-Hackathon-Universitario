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
    /*
     * [CODE REVIEW #9 - Design de colecao]
     * Map<Jurado, Integer> usa Jurado como chave, mas Pessoa nao sobrescreve
     * equals()/hashCode(). HashMap compara por referencia, nao por identidade logica.
     * Sugestao: implementar equals/hashCode em Pessoa com base no CPF.
     */
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
            /*
             * [CODE REVIEW #10 - Violacao de SRP]
             * Camada de dominio faz System.out.println. Dominio nao deveria conhecer console.
             * Sugestao: retornar double ou usar Logger na camada de apresentacao.
             */
            System.out.println("Não há jurados para avaliar.");
            projetoAvaliado.setNotaFinal(0);
            return;
        }

        int somaNotas = jurados.values().stream().mapToInt(Integer::intValue).sum();
        double media = (double) somaNotas / jurados.size();

        /*
         * [CODE REVIEW #11 - Acoplamento]
         * Banca modifica diretamente o estado de Projeto via setNotaFinal().
         * Sugestao: Banca retorna a media e Apresentacao.avaliar() atribui ao Projeto.
         */
        projetoAvaliado.setNotaFinal(media);

        System.out.println("Nota final calculada para o projeto '" + projetoAvaliado.getTitulo() + "': " + media);
    }
}
