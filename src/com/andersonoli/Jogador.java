package com.andersonoli;

public class Jogador {
    public int score;
    public String nome;
    public boolean turno;
    public String simbolo;

    public Jogador(String nomeJogador){
        this.nome = nomeJogador;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
