package View;

import Controller.TelaEscolherJogadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaEscolherJogador extends JFrame {

    public TelaEscolherJogador(TelaEscolherJogadorController controller) {
        setTitle("Escolher Jogador");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton inicianteBtn = new JButton("Iniciante");
        JButton veteranoBtn = new JButton("Veterano");

        inicianteBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Iniciante"));
        veteranoBtn.addActionListener((ActionEvent e) -> controller.jogadorSelecionado("Veterano"));

        JPanel panel = new JPanel();
        panel.add(inicianteBtn);
        panel.add(veteranoBtn);

        add(panel);
        setVisible(true);
    }
}
