package Controller;

import Dominio.Jogador;
import Dominio.JogadorIniciante;
import Dominio.JogadorVeterano;
import View.TelaEscolherJogador;

public class TelaEscolherJogadorController {
    Jogador jogador;

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
