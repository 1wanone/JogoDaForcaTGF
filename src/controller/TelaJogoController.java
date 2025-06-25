package controller;

import dominio.*;
import ui.TelaJogo;

import javax.swing.*;

public class TelaJogoController {
    private final JogoDaForca jogo;

    public TelaJogoController(Jogador jogador, Tema tema) {
        Palavra palavra = tema.sorteiaPalavra();
        jogo = new JogoDaForca();
        jogo.iniciarPartida(tema, palavra, jogador);
    }

    public void mostrarTela() {
        new TelaJogo(this, jogo.getPartidaAtual());
    }

    public void processarTentativa(char letra, TelaJogo tela) {
        try {
            Partida partida = jogo.getPartidaAtual();
            boolean acertou = partida.tentativa(letra);

            tela.atualizarTela();

            if (!acertou) {
                tela.mostrarAnimacaoErro();
            } else {
                tela.voltarAnimacaoPadrao();
            }

            if (partida.venceu()) {
                tela.mostrarAnimacaoVitoria();
                JOptionPane.showMessageDialog(null, "Parabéns! Você venceu!");
                perguntarJogarNovamente(tela);
            } else if (partida.terminou()) {
                JOptionPane.showMessageDialog(null, "Game Over! A palavra era: " + partida.getPalavra().getPalavraSecreta());
                perguntarJogarNovamente(tela);
            }

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Tentativa inválida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void perguntarJogarNovamente(TelaJogo tela) {
        String[] opcoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(
                null,
                "Deseja jogar novamente?",
                "Jogar Novamente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (resposta == 0) {
            tela.dispose();
            new TelaEscolherJogadorController().mostrarTela();

        } else {
            System.exit(0);
        }
    }

}
