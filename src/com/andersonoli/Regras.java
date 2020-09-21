package com.andersonoli;

import java.util.ArrayList;

public class Regras {
    private StringBuilder buffer;
    private final Tabuleiro tabuleiro;

    public Regras(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    public boolean verificarJogada(Jogada novaJogada) throws Exception {
        Jogador jogador = novaJogada.jogador;

        String valorJogado = novaJogada.valor;
        String simboloJogador = jogador.simbolo;

        if(!valorJogado.equals(simboloJogador)){
            if(jogador.simbolo != null){
                throw new Exception("\n" + jogador.nome + ", seu símbolo é " + jogador.simbolo);
            }
            throw new Exception("\n" + jogador.nome + ", outro jogador já está utilizando este símbolo.");
        } else if (tabuleiro.getTabuleiro().get(novaJogada.indiceJogada-1).getValor() != null){
            throw new Exception("\n" + jogador.nome + ", o local já está preenchido.");
        }

        return true;
    }

    public boolean verificarVitoria(){
        this.buffer = new StringBuilder();

        ArrayList<Zona> board = this.tabuleiro.getTabuleiro();

        /*
            [ 1, 2, 3
              4, 5, 6
              7, 8, 9 ]
        */

        /*
            2, 4, 6 (2 em 2)
        */
        for (int i = 2; i <= 6; i+=2) {
            buffer.append(board.get(i).getValor());
        }

        if(verificarSequencia(true)) return true;

        /*
            0, 4, 8 (4 em 4)
         */
        for (int k = 0; k < 9; k+=4) {
            buffer.append(board.get(k).getValor());
        }

        if(verificarSequencia(true)) return true;

        /*
            0, 3, 6 (3 em 3)
            1, 4, 7 (3 em 3)
            2, 5, 8 (3 em 3)
         */
        for (int m = 0; m < 3; m++) {
            for (int l = m; l < 9; l+=3) {
                buffer.append(board.get(l).getValor());
            }

            if(verificarSequencia(true)) return true;
        }

        // 3 iguais em sequência
        for (int n = 0; n <= 8; n++) {
            buffer.append(board.get(n).getValor());

            if(verificarSequencia(false)) return true;
            if(n == 2 || n == 5 || n == 8) this.buffer.setLength(0);
        }

        return false;
    }

    public boolean verificarSequencia(boolean clear){
        String query = this.buffer.toString().toLowerCase();

        if(clear) this.buffer.setLength(0);

        return query.equals("xxx") || query.equals("ooo");
    }
}
