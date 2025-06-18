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
            perguntarJogarNovamente(tela);
        } else if (partida.terminou()) {
            JOptionPane.showMessageDialog(null, "Game Over! A palavra era: " + partida.getProgresso());
            perguntarJogarNovamente(tela);
        }
    }

    private void perguntarJogarNovamente(TelaJogo tela) {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Jogar Novamente", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            tela.dispose();
            TelaEscolherJogadorController controller = new TelaEscolherJogadorController();
            controller.mostrarTela();
        } else {
            System.exit(0);
        }
    }
}
