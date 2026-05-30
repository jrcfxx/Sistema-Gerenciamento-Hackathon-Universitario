/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public class Estudante extends Pessoa {

    /*
     * [CODE REVIEW #23 - Marker class]
     * Subclasse nao adiciona atributos nem comportamento. Alternativas: enum
     * TipoPessoa ou atributo Role em Pessoa. Se mantiver heranca, documentar intencao.
     */
    public Estudante(String nome, String cpf, Instituicao instituicao) {
        super(nome, cpf, instituicao);
    }
}
