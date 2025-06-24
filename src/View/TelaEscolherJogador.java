package View;

import Controller.TelaEscolherJogadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;


public class TelaEscolherJogador extends JFrame {

    public TelaEscolherJogador(TelaEscolherJogadorController controller) {
        setTitle("🎮 Escolher Jogador");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel(" Bem-vindo ao Jogo da Forca!");
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);


        JButton inicianteBtn = new JButton(" Iniciante");
        JButton veteranoBtn = new JButton(" Veterano");

        estilizarBotao(inicianteBtn, new Color(76, 175, 80));
        estilizarBotao(veteranoBtn, new Color(3, 169, 244));


        inicianteBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Iniciante"));
        veteranoBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Veterano"));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(255, 253, 230));
        panel.add(titulo);
        panel.add(inicianteBtn);
        panel.add(veteranoBtn);

        add(panel);
        setVisible(true);
    }

    private void estilizarBotao(JButton botao, Color corFundo) {
        botao.setBackground(corFundo);
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        botao.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
    }


}