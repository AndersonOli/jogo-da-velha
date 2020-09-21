package com.andersonoli;

public class Jogada {
    public String valor;
    public Jogador jogador;
    public int indiceJogada;

    public Jogada(String valor, Jogador jogador, int indiceJogada){
        this.valor = valor;
        this.jogador = jogador;
        this.indiceJogada = indiceJogada;
    }
}
