package ui;

import controller.TelaEscolherTemaController;
import dominio.Tema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaEscolherTema extends JFrame {

    public TelaEscolherTema(TelaEscolherTemaController controller, List<Tema> temas) {
        setTitle("🎯 Escolher Tema");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fundo pixelado
        FundoPixelArt fundo = new FundoPixelArt("/imagens/fundoEscolherTema.png");
        fundo.setLayout(null);

        // ComboBox de temas
        JComboBox<String> comboBox = new JComboBox<>();
        for (Tema tema : temas) {
            comboBox.addItem(tema.getNome());
        }
        comboBox.setBounds(240, 250, 200, 40); // Ajuste para alinhar com o fundo
        comboBox.setBackground(new java.awt.Color(255, 255, 255));
        comboBox.setForeground(java.awt.Color.BLACK);
        comboBox.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        fundo.add(comboBox);

        // Botão Jogar
        JButton jogarBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntJogar.png")));
        estilizarBotaoPixel(jogarBtn);
        jogarBtn.setBounds(250, 320, 200, 50); // Ajuste conforme imagem
        jogarBtn.addActionListener((ActionEvent e) -> {
            int index = comboBox.getSelectedIndex();
            controller.temaSelecionado(temas.get(index));
            dispose();
        });

        fundo.add(jogarBtn);

        // Finalizar janela
        setContentPane(fundo);
        setVisible(true);
    }

    private void estilizarBotaoPixel(JButton botao) {
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
    }
}
