package com.andersonoli;

import java.util.ArrayList;

public class GameController {
    public Regras regras;
    public int indiceJogador;
    public Tabuleiro tabuleiro;
    public ArrayList<Jogador> jogadores = new ArrayList<>();

    public GameController(Jogador jogadorUm, Jogador jogadorDois){
        this.tabuleiro = new Tabuleiro();
        this.regras = new Regras(this.tabuleiro);

        this.jogadores.add(jogadorUm);
        this.jogadores.add(jogadorDois);

        // Definindo quem será o primeiro a começar
        this.indiceJogador = getAleatorio(2);
        this.jogadores.get(indiceJogador).setTurno(true);
    }

    public int getAleatorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public void alterarJogador(int indiceJogador) {
        this.indiceJogador = indiceJogador == 0 ? 1 : 0;

        this.jogadores.get(indiceJogador).setTurno(false);
        this.jogadores.get(this.indiceJogador).setTurno(true);
    }

    public void novaJogada(int indice, Jogador jogador, String valor) throws Exception {
        if(jogador.simbolo == null && !valor.equals(jogadores.get(indiceJogador == 0 ? 1 : 0).simbolo)){
            jogador.setSimbolo(valor);
        }

        if(this.regras.verificarJogada(new Jogada(valor, jogador, indice))){
            this.tabuleiro.getTabuleiro().get(indice - 1).setValor(valor);
        }
    }

    public void mostrarTabuleiroAtual(){
        for (int i = 0; i < 9; i++) {
            String valor = this.tabuleiro.getTabuleiro().get(i).getValor();

            if(i == 0) System.out.println();

            System.out.printf("%-10s", valor == null ? "[" + (i + 1) + "]" : valor.toUpperCase());
            System.out.print("\t");

            if(i == 2 || i == 5) System.out.println();
        }
    }

    public void novoJogo(){
        this.tabuleiro.limparTabuleiro();
        this.tabuleiro.criarTabuleiro();
        this.alterarJogador(this.indiceJogador);
    }
}
