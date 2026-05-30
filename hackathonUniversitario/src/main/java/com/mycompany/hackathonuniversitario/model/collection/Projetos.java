/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hackathonuniversitario.model.collection;

import com.mycompany.hackathonuniversitario.model.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Júlia
 */
public class Projetos {

    /*
     * [CODE REVIEW #24 - DRY / Padrao Repository]
     * Cinco classes em model.collection repetem a mesma estrutura Singleton + ArrayList.
     * Sugestao: classe generica SingletonRepository<T> ou interfaces Repository separadas
     * para facilitar troca por JDBC/API no futuro.
     */
    private static Projetos instancia;
    private List<Projeto> listaProjetos;

    private Projetos() {
        listaProjetos = new ArrayList<>();
    }

    public static Projetos getInstancia() {
        if (instancia == null) {
            instancia = new Projetos();
        }
        return instancia;
    }

    public void adicionarProjeto(Projeto projeto) {
        listaProjetos.add(projeto);
    }

    public List<Projeto> getTodosProjetos() {
        return listaProjetos;
    }

    public List<Projeto> buscarPorTitulo(String titulo) {
        return listaProjetos.stream()
                .filter(p -> p.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }
}
