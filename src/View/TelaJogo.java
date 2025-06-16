package View;

import Controller.TelaJogoController;
import Dominio.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaJogo extends JFrame {
    private JLabel progressoLabel;
    private JLabel errosLabel;
    private JTextField letraInput;
    private Partida partida;
    private TelaJogoController controller;

    public TelaJogo(TelaJogoController controller, Partida partida) {
        this.controller = controller;
        this.partida = partida;

        setTitle("Jogo da Forca");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        progressoLabel = new JLabel(partida.getProgresso());
        errosLabel = new JLabel("Erros: " + partida.getErros());
        letraInput = new JTextField(1);
        JButton tentarBtn = new JButton("Tentar");

        tentarBtn.addActionListener((ActionEvent e) -> {
            char letra = letraInput.getText().charAt(0);
            controller.processarTentativa(letra, this);
            letraInput.setText("");
        });

        setLayout(new GridLayout(4, 1));
        add(progressoLabel);
        add(errosLabel);
        add(letraInput);
        add(tentarBtn);

        setVisible(true);
    }

    public void atualizarTela() {
        progressoLabel.setText(partida.getProgresso());
        errosLabel.setText("Erros: " + partida.getErros());
    }
}
