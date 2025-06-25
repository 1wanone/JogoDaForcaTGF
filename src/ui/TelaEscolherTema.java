package ui;

import controller.TelaEscolherTemaController;
import dominio.Tema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaEscolherTema extends JFrame {

    public TelaEscolherTema(TelaEscolherTemaController controller, List<Tema> temas) {
        try {
            setTitle("🎯 Escolher Tema");
            setSize(700, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            FundoPixelArt fundo = new FundoPixelArt("/imagens/fundoEscolherTema.png");
            fundo.setLayout(null);

            JComboBox<String> comboBox = new JComboBox<>();
            for (Tema tema : temas) {
                comboBox.addItem(tema.getNome());
            }
            comboBox.setBounds(240, 250, 200, 40);
            fundo.add(comboBox);

            JButton jogarBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntJogar.png")));
            estilizarBotaoPixel(jogarBtn);
            jogarBtn.setBounds(250, 320, 200, 50);
            jogarBtn.addActionListener((ActionEvent e) -> {
                try {
                    int index = comboBox.getSelectedIndex();
                    if (index >= 0) {
                        controller.temaSelecionado(temas.get(index));
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Por favor, selecione um tema.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao iniciar jogo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            fundo.add(jogarBtn);
            setContentPane(fundo);
            setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir a tela de temas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void estilizarBotaoPixel(JButton botao) {
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
    }
}
