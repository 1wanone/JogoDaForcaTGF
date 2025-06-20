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
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);


        JButton inicianteBtn = new JButton(" Iniciante");
        JButton veteranoBtn = new JButton(" Veterano");

        inicianteBtn.setBackground(Color.green);
        veteranoBtn.setBackground(Color.cyan);

        inicianteBtn.setFont(new Font("Arial", Font.BOLD, 25));
        veteranoBtn.setFont(new Font("Arial", Font.BOLD, 25));


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
}
