package Controller;

import Dominio.*;

import View.TelaJogo;

import javax.swing.*;

public class TelaJogoController {
    private JogoDaForca jogo;

    public TelaJogoController(Jogador jogador, Tema tema) {
        Palavra palavra = tema.sorteiaPalavra();
        jogo = new JogoDaForca();
        jogo.iniciarPartida(tema, palavra, jogador);
    }

    public void mostrarTela() {
        new TelaJogo(this, jogo.getPartidaAtual());
    }

    public void processarTentativa(char letra, TelaJogo tela) {
        Partida partida = jogo.getPartidaAtual();
        partida.tentativa(letra);

        tela.atualizarTela();

        if (partida.venceu()) {
            JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!");
        } else if (partida.terminou()) {
            JOptionPane.showMessageDialog(null, "Game Over! A palavra era: " + partida.getProgresso());
        }
    }
}
