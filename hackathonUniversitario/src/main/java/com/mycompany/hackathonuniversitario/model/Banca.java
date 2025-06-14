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

    public void calcularNotaFinal() {
        System.out.println("calcularNotaFinal");
    }
}
