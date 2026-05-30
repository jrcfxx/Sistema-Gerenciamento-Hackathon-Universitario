/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

import java.time.LocalDateTime;

/**
 *
 * @author Júlia
 */
public class Apresentacao {

    private Projeto projeto;
    /*
     * [CODE REVIEW #12 - Padrao Strategy]
     * Uso de Avaliavel em vez de Banca concreta e bom polimorfismo (OCP).
     * Sugestao: criar outras implementacoes (AvaliacaoRemota, AvaliacaoPresencial)
     * para demonstrar extensibilidade sem alterar Apresentacao.
     */
    private Avaliavel banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Avaliavel banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    /*
     * [CODE REVIEW #13 - Imutabilidade]
     * Setters permitem alterar projeto/banca/local apos agendamento, gerando
     * inconsistencia (ex.: trocar banca depois de calcular nota). Sugestao: remover
     * setters ou validar transicoes de estado apos avaliar().
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Avaliavel getBanca() {
        return banca;
    }

    public void setBanca(Avaliavel banca) {
        this.banca = banca;
    }

    public Sala getLocal() {
        return local;
    }

    public void setLocal(Sala local) {
        this.local = local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void avaliar() {
        banca.calcularNotaFinal();
        /*
         * [CODE REVIEW #14 - Efeito colateral no dominio]
         * avaliar() imprime no console. Sugestao: retornar ResultadoAvaliacao
         * e deixar a camada de apresentacao exibir o resultado.
         */
        System.out.println("Avaliação realizada para o projeto: " + projeto.getTitulo()
                + " com nota final: " + projeto.getNotaFinal());
    }
}
