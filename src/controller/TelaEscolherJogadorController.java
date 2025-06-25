package controller;

import dominio.Jogador;
import dominio.JogadorIniciante;
import dominio.JogadorVeterano;
import ui.TelaEscolherJogador;

public class TelaEscolherJogadorController {
    private Jogador jogador;

    public void mostrarTela() {
        new TelaEscolherJogador(this);
    }

    public void jogadorSelecionado(String tipoJogador) {
        if (tipoJogador.equals("Iniciante")) {
            jogador = new JogadorIniciante();
        } else {
            jogador = new JogadorVeterano();
        }
        new TelaEscolherTemaController(jogador).mostrarTela();
    }
}
