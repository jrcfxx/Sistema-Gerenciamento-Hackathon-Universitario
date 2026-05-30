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

    /*
     * [CODE REVIEW #1 - Arquitetura]
     * O metodo main concentra toda a orquestracao do sistema (equipes, projetos,
     * bancas, apresentacoes e saida no console). Isso configura um God Method.
     * Sugestao: extrair um HackathonService ou Facade para separar responsabilidades
     * e facilitar testes unitarios sem depender de System.out.
     */
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

        /*
         * [CODE REVIEW #2 - Inconsistencia arquitetural]
         * Projetos sao criados como variaveis locais, mas existe o Singleton Projetos
         * em model.collection que nunca e utilizado aqui. Sugestao: registrar com
         * Projetos.getInstancia().adicionarProjeto(projeto) para manter fonte unica de verdade.
         */
        Projeto projeto1 = new Projeto("Sistema Legal", orientador1, equipe1);
        Projeto projeto2 = new Projeto("Aplicativo Sensacional", orientador2, equipe2);

        // Criar uma banca avaliadora para cada projeto (cada banca deve conter 4 jurados);
        Map<Jurado, Integer> notasBanca1 = new HashMap<>();
        Map<Jurado, Integer> notasBanca2 = new HashMap<>();

        /*
         * [CODE REVIEW #3 - DRY / Refatoracao]
         * Os dois loops de criacao de jurados sao praticamente identicos. Sugestao:
         * extrair metodo criarNotasBanca(Empresa empresa, String prefixo) para reduzir
         * duplicacao e facilitar manutencao da regra de notas.
         */
        // Random gera nota entre 5 a 10
        for (int i = 1; i <= 4; i++) {
            Jurado jurado = new Jurado(
                    "Jurado Daniel" + i,
                    "444.444.444-0" + i,
                    new Empresa("Empresa Legal", "EL", "Belo Horizonte", "MG", "Tecnologia"),
                    "Tecnologia");
            /*
             * [CODE REVIEW #4 - Code smell]
             * new Random() e instanciado a cada iteracao do loop. Sugestao: declarar
             * Random random = new Random() fora do loop ou usar ThreadLocalRandom.
             */
            notasBanca1.put(jurado, new Random().nextInt(6) + 5);
        }

        // Random gera nota entre 5 a 10
        for (int i = 1; i <= 4; i++) {
            Jurado jurado = new Jurado(
                    "Jurado Daniel 2" + i,
                    "555.555.555-0" + i,
                    new Empresa("Empresa Sensacional", "ES", "Belo Horizonte", "MG", "Inovação"),
                    "Inovação");
            notasBanca2.put(jurado, new Random().nextInt(6) + 5);
        }

        /*
         * [CODE REVIEW #5 - Inconsistencia arquitetural]
         * Bancas sao criadas localmente, mas o Singleton Bancas nao e utilizado.
         * Sugestao: Bancas.getInstancia().adicionarBanca(banca).
         */
        Banca banca1 = new Banca(projeto1, notasBanca1);
        Banca banca2 = new Banca(projeto2, notasBanca2);

        /*
         * [CODE REVIEW #6 - Inconsistencia arquitetural]
         * Salas sao instanciadas inline sem passar pelo Singleton Salas, que ja possui
         * adicionarSala() e buscarPorId(). Sugestao: registrar salas no repositorio.
         */
        Apresentacao apresentacao1 = new Apresentacao(projeto1, banca1, new Sala("Sala A", 30, "Bloco 1"),
                LocalDateTime.now());
        Apresentacao apresentacao2 = new Apresentacao(projeto2, banca2, new Sala("Sala B", 25, "Bloco 2"),
                LocalDateTime.now());

        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao1);
        Apresentacoes.getInstancia().adicionarApresentacao(apresentacao2);

        // Calcula a nota final de cada projeto a partir da apresentação (considere a média das notas dos jurados);
        apresentacao1.avaliar();
        apresentacao2.avaliar();

        /*
         * [CODE REVIEW #7 - Separacao Model/View]
         * Formatacao visual (banners com ===) esta misturada com logica no main.
         * Sugestao: criar classe RelatorioConsole ou ResultadoView responsavel pela saida.
         */
        System.out.println("\n===============================================");
        System.out.println("         RESULTADO DOS PROJETOS APROVADOS       ");
        System.out.println("===============================================");

        // Lista os projetos com nota final ≥ 7 (usar stream).
        System.out.println("\nProjetos aprovados (nota >= 7):");
        Apresentacoes.getInstancia().getTodasApresentacoes().stream()
                /*
                 * [CODE REVIEW #8 - Constante magica]
                 * Valor 7 (nota minima) esta hardcoded. Sugestao: private static final
                 * double NOTA_MINIMA_APROVACAO = 7.0;
                 */
                .filter(a -> a.getProjeto().getNotaFinal() >= 7)
                .forEach(a -> System.out
                        .println(a.getProjeto().getTitulo() + " - Nota: " + a.getProjeto().getNotaFinal()));

        System.out.println("===============================================\n");
    }
}
