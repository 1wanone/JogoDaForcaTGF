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

        setTitle("🎲 Jogo da Forca");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("🔤 Adivinhe a Palavra!");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        progressoLabel = new JLabel(partida.getProgresso());
        progressoLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        progressoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        errosLabel = new JLabel("Erros: " + partida.getErros());
        errosLabel.setFont(new Font("Arial", Font.BOLD, 30));
        errosLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel dica = new JLabel("Digite uma letra:");
        dica.setHorizontalAlignment(SwingConstants.CENTER);

        letraInput = new JTextField(2);


        JButton tentarBtn = new JButton("✔ Tentar");
        tentarBtn.setBackground(Color.LIGHT_GRAY);
        tentarBtn.setFont(new Font("Arial", Font.BOLD, 16));

        tentarBtn.addActionListener((ActionEvent e) -> {
            String texto = letraInput.getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite uma letra!", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                char letra = texto.charAt(0);
                controller.processarTentativa(letra, this);
                letraInput.setText("");
            }
        });

        JPanel painelCentro = new JPanel(new GridLayout(4, 1, 5, 5));
        painelCentro.setBackground(new Color(240, 255, 240));
        painelCentro.add(progressoLabel);
        painelCentro.add(errosLabel);
        painelCentro.add(dica);
        painelCentro.add(letraInput);
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
