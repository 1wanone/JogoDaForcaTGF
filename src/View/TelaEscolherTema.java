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
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);


        JComboBox<String> comboBox = new JComboBox<>();
        for (Tema tema : temas) {
            comboBox.addItem(tema.getNome());
        }

        JButton jogarBtn = new JButton(" Jogar");
        jogarBtn.setBackground(Color.CYAN);
        jogarBtn.setFont(new Font("Arial", Font.BOLD, 30));

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
}
