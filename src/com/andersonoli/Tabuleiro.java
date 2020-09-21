package com.andersonoli;

import java.util.ArrayList;

public class Tabuleiro {
    private final ArrayList<Zona> tabuleiro = new ArrayList<>();

    public Tabuleiro(){
        this.criarTabuleiro();
    }

    public void criarTabuleiro(){
        int TAMANHO_TABULEIRO = 3;

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                this.tabuleiro.add(new Zona());
            }
        }
    }

    public void limparTabuleiro(){
        this.tabuleiro.clear();
    }

    public ArrayList<Zona> getTabuleiro() {
        return tabuleiro;
    }
}
