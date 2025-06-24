package View;

import Controller.TelaEscolherTemaController;
import Dominio.Tema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class TelaEscolherTema extends JFrame {


    public TelaEscolherTema(TelaEscolherTemaController controller, List<Tema> temas) {
        setTitle("🎯 Escolha um Tema");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel(" Escolha um tema para começar!");
        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        //titulo.setFont(pixelFont.deriveFont(20f));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);


        JComboBox<String> comboBox = new JComboBox<>();
        for (Tema tema : temas) {
            comboBox.addItem(tema.getNome());
        }

        comboBox.setBackground(new Color(255, 250, 205));
        comboBox.setForeground(Color.BLACK);
        comboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        JButton jogarBtn = new JButton(" Jogar");
        estilizarBotao(jogarBtn, new Color(0, 255, 200));

        jogarBtn.addActionListener((ActionEvent e) -> {
            int index = comboBox.getSelectedIndex();
            controller.temaSelecionado(temas.get(index));
            dispose();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(230, 231, 255));
        panel.add(titulo);
        panel.add(comboBox);
        panel.add(jogarBtn);

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
