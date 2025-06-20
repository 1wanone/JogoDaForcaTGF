package View;

import Controller.TelaEscolherJogadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.InputStream;




public class TelaEscolherJogador extends JFrame {

    private Font pixelFont;

    public TelaEscolherJogador(TelaEscolherJogadorController controller) {
        pixelFont = carregarFontePixel();
        setTitle("🎮 Escolher Jogador");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font pixelFont = carregarFontePixel();

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

    private Font carregarFontePixel() {
        try {
            InputStream is = getClass().getResourceAsStream("/fontes/PressStart2P.ttf");
            if (is == null) {
                // Fonte não encontrada, usar fonte padrão
               // System.out.println("❌ Fonte não encontrada, usando Arial.");
                return new Font("Arial", Font.BOLD, 20);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            // Qualquer outro erro, usar fonte padrão
            System.out.println("⚠️ Erro ao carregar fonte, usando Arial.");
            return new Font("Arial", Font.BOLD, 20);
        }

    }
}