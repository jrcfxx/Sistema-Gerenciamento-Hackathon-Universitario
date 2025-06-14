/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hackathonuniversitario;

import com.mycompany.hackathonuniversitario.model.*;
import com.mycompany.hackathonuniversitario.model.collection.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author Júlia
 */
public class HackathonUniversitario {

    public static void main(String[] args) {
        Instituicao univ1 = new Universidade("Universidade Federal de Teste", "UFT", "Belo Horizonte", "Minas Gerais");
        Instituicao univ2 = new Universidade("Universidade Estadual de Exemplo", "UEE", "Sao Paulo", "Sao Paulo");

        // Cria 2 equipes com 5 alunos cada;
        Equipe equipe1 = new Equipe("Equipe Bombastica");
        Equipe equipe2 = new Equipe("Equipe Mesopotamica");

        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno" + i, "000.000.000-0" + i, univ1));
            equipe2.adicionarMembro(new Estudante("AlunoB" + i, "111.111.111-1" + i, univ2));
        }

        Equipes.getInstancia().adicionarEquipe(equipe1);
        Equipes.getInstancia().adicionarEquipe(equipe2);

        // Adiciona um projeto diferente para cada equipe;
        Profissional orientador1 = new Profissional("Daniel", "222.222.222-22", univ1, "Engenharia");
        Profissional orientador2 = new Profissional("Daniel 2", "333.333.333-33", univ2, "Computação");

        Projeto projeto1 = new Projeto("Sistema Legal", orientador1, equipe1);
        Projeto projeto2 = new Projeto("Aplicativo Sensacional", orientador2, equipe2);

        // Criar uma banca avaliadora para cada projeto (cada banca deve conter 4 jurados);
        Map<Jurado, Integer> notasBanca1 = new HashMap<>();
        Map<Jurado, Integer> notasBanca2 = new HashMap<>();

        for (int i = 1; i <= 4; i++) {
            Jurado jurado = new Jurado(
                    "Jurado Daniel" + i,
                    "444.444.444-0" + i,
                    new Empresa("Empresa Legal", "EL", "Belo Horizonte", "MG", "Tecnologia"),
                    "Tecnologia");
            notasBanca1.put(jurado, new Random().nextInt(4) + 7);
        }

        for (int i = 1; i <= 4; i++) {
            Jurado jurado = new Jurado(
                    "Jurado Daniel 2" + i,
                    "555.555.555-0" + i,
                    new Empresa("Empresa Sensacional", "ES", "Belo Horizonte", "MG", "Inovação"),
                    "Inovação");
            notasBanca2.put(jurado, new Random().nextInt(4) + 5);
        }

        Banca banca1 = new Banca(projeto1, notasBanca1);
        Banca banca2 = new Banca(projeto2, notasBanca2);

        Apresentacao apresentacao1 = new Apresentacao(projeto1, banca1, new Sala("Sala A", 30, "Bloco 1"),
                LocalDateTime.now());
        Apresentacao apresentacao2 = new Apresentacao(projeto2, banca2, new Sala("Sala B", 25, "Bloco 2"),
                LocalDateTime.now());

        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao1);
        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao2);

        // Calcula a nota final de cada projeto a partir da apresentação (considere a média das notas dos jurados);
        apresentacao1.avaliar();
        apresentacao2.avaliar();

        // Lista os projetos com nota final ≥ 7 (usar stream).
        System.out.println("\nProjetos aprovados (nota >= 7):");
        Apresentacoes.getInstancia().getTodasApresentacoes().stream()
                .filter(a -> a.getProjeto().getNotaFinal() >= 7)
                .forEach(a -> System.out
                        .println(a.getProjeto().getTitulo() + " - Nota: " + a.getProjeto().getNotaFinal()));
    }
}
