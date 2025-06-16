package View;

import Controller.TelaEscolherTemaController;
import Dominio.Tema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaEscolherTema extends JFrame {

    public TelaEscolherTema(TelaEscolherTemaController controller, List<Tema> temas) {
        setTitle("Escolher Tema");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JComboBox<String> comboBox = new JComboBox<>();
        for (Tema tema : temas) {
            comboBox.addItem(tema.getNome());
        }

        JButton jogarBtn = new JButton("Jogar");

        jogarBtn.addActionListener((ActionEvent e) -> {
            int index = comboBox.getSelectedIndex();
            controller.temaSelecionado(temas.get(index));
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(jogarBtn);

        add(panel);
        setVisible(true);
    }
}
