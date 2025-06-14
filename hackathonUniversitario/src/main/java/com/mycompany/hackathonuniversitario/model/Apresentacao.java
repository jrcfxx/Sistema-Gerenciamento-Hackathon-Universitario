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
public class Apresentacao implements Avaliavel {

    private Projeto projeto;
    private Avaliavel banca;
    private Sala local;
    private LocalDateTime dataHora;

    public void avaliar() {
        System.out.println("avaliar");
    }

}
