/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model.collection;

import com.mycompany.hackathonuniversitario.model.Sala;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Júlia
 */
public class Salas {

    private static Salas instancia;
    private List<Sala> listaSalas;

    private Salas() {
        listaSalas = new ArrayList<>();
    }

    public static Salas getInstancia() {
        if (instancia == null) {
            instancia = new Salas();
        }
        return instancia;
    }

    public void adicionarSala(Sala sala) {
        listaSalas.add(sala);
    }

    public List<Sala> getTodasSalas() {
        return listaSalas;
    }

    public Optional<Sala> buscarPorId(String id) {
        return listaSalas.stream()
                .filter(s -> s.getIdentificador().equalsIgnoreCase(id))
                .findFirst();
    }
}
