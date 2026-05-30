/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model;

/**
 *
 * @author Júlia
 */
public interface Avaliavel {

    /*
     * [CODE REVIEW #22 - Contrato da interface]
     * Retorno void dificulta testar o resultado sem inspecionar estado mutado de
     * outras entidades. Sugestao: double calcularNotaFinal() retornando a media.
     */
    void calcularNotaFinal();
}
