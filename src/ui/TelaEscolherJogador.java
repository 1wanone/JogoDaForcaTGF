package ui;

import controller.TelaEscolherJogadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaEscolherJogador extends JFrame {

    public TelaEscolherJogador(TelaEscolherJogadorController controller) {
        try {
            setTitle("Escolher Jogador");
            setSize(700, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            FundoPixelArt fundo = new FundoPixelArt("/imagens/fundoEscolherJogador.png");

            JButton inicianteBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntIniciante.png")));
            Utils.estilizarBotaoPixel(inicianteBtn);
            inicianteBtn.setBounds(250, 250, 200, 50);

            JButton veteranoBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntVeterano.png")));
            Utils.estilizarBotaoPixel(veteranoBtn);
            veteranoBtn.setBounds(250, 320, 200, 50);

            inicianteBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Iniciante"));
            veteranoBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Veterano"));

            fundo.add(inicianteBtn);
            fundo.add(veteranoBtn);

            setContentPane(fundo);
            setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de jogador: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
