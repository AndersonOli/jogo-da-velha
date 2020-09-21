package com.andersonoli;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int contador = 0;
        Jogador jogadorUm, jogadorDois;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Insira o nome do primeiro Jogador..: ");
        jogadorUm = new Jogador(entrada.nextLine());

        System.out.print("Insira o nome do segundo Jogador...: ");
        jogadorDois = new Jogador(entrada.nextLine());

        GameController jogo = new GameController(jogadorUm, jogadorDois);

        while(contador < 9) {
            jogo.mostrarTabuleiroAtual();

            System.out.println("\n\nVez de " + jogo.jogadores.get(jogo.indiceJogador).nome);
            System.out.print("\nOnde deseja jogar [1 - 9]: ");
            int indice = Integer.parseInt(entrada.next());

            System.out.print("X ou O: ");
            String valor = entrada.next().toLowerCase();

            try {
                jogo.novaJogada(indice, jogo.jogadores.get(jogo.indiceJogador), valor);

                if(jogo.regras.verificarVitoria()){
                    jogo.mostrarTabuleiroAtual();
                    System.out.println("\nFIM DE JOGO!");
                    System.out.println(jogo.jogadores.get(jogo.indiceJogador).nome + " É O GANHADOR!");

                    System.out.print("\nDeseja jogar novamente? [S/n]: ");
                    String resp = entrada.next().toLowerCase();

                    if(resp.equals("s")){
                        contador = 0;

                        jogo.novoJogo();

                        continue;
                    }

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            jogo.alterarJogador(jogo.indiceJogador);

            contador++;

            if(contador == 9 && !(jogo.regras.verificarVitoria())){
                System.out.println("\nDEU VELHA!");

                System.out.print("\nDeseja jogar novamente? [S/n]: ");
                String resp = entrada.next().toLowerCase();

                if(resp.equals("s")){
                    contador = 0;

                    jogo.novoJogo();

                    continue;
                }

                break;
            }
        }
    }
}
