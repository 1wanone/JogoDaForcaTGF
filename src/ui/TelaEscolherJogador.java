package ui;

import controller.TelaEscolherJogadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaEscolherJogador extends JFrame {

    public TelaEscolherJogador(TelaEscolherJogadorController controller) {
        setTitle("🎮 Escolher Jogador");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FundoPixelArt fundo = new FundoPixelArt("/imagens/fundoEscolherJogador.png");

        // Botão Iniciante
        JButton inicianteBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntIniciante.png")));
        estilizarBotaoPixel(inicianteBtn);
        inicianteBtn.setBounds(250, 250, 200, 50); // ajuste como quiser

        // Botão Veterano
        JButton veteranoBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntVeterano.png")));
        estilizarBotaoPixel(veteranoBtn);
        veteranoBtn.setBounds(250, 320, 200, 50);

        inicianteBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Iniciante"));
        veteranoBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Veterano"));

        fundo.add(inicianteBtn);
        fundo.add(veteranoBtn);

        setContentPane(fundo);
        setVisible(true);
    }

    private void estilizarBotaoPixel(JButton botao) {
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
    }
}
