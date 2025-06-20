package View;

import Controller.TelaJogoController;
import Dominio.Partida;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaJogo extends JFrame {
    private JLabel progressoLabel;
    private JLabel tentativasLabel; // NOVO: Label para tentativas
    private JTextField letraInput;
    private JButton tentarBtn;
    private Partida partida;
    private TelaJogoController controller;
    private AnimacaoGarota painelFundo;

    public TelaJogo(TelaJogoController controller, Partida partida) {
        this.controller = controller;
        this.partida = partida;

        setTitle("🎲 Jogo da Forca");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carrega animação da garota padrão
        String[] framesPadrao = {
                "/imagens/meninaForcaPadraoFinal1.png",
                "/imagens/meninaForcaPadraoFinal2.png"
        };
        List<Image> framesIniciais = Utils.carregarFrames(framesPadrao);
        painelFundo = new AnimacaoGarota(framesIniciais, 500);
        painelFundo.setLayout(null);

        setContentPane(painelFundo);

        // Painel flutuante no topo direito com BoxLayout centralizado
        JPanel painelDireita = new JPanel();
        painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
        painelDireita.setOpaque(false);

        // Label de progresso
        progressoLabel = new JLabel(partida.getProgresso());
        progressoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        progressoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // NOVO: Label de tentativas restantes
        tentativasLabel = new JLabel("Tentativas restantes: " + partida.getTentativasRestantes());
        tentativasLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        tentativasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campo de texto
        letraInput = new JTextField(2);
        letraInput.setFont(new Font("Arial", Font.BOLD, 24));
        letraInput.setMaximumSize(new Dimension(80, 20));
        letraInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão de tentativa
        tentarBtn = new JButton("Tentar");
        tentarBtn.setFont(new Font("Arial", Font.BOLD, 20));
        tentarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        tentarBtn.addActionListener(e -> {
            String texto = letraInput.getText().trim();
            if (!texto.isEmpty()) {
                char letra = texto.charAt(0);
                controller.processarTentativa(letra, this);
                letraInput.setText("");
            }
        });

        // Adicionando componentes com espaçamentos
        painelDireita.add(progressoLabel);
        painelDireita.add(Box.createVerticalStrut(5));
        painelDireita.add(tentativasLabel); // NOVO
        painelDireita.add(Box.createVerticalStrut(10));
        painelDireita.add(letraInput);
        painelDireita.add(Box.createVerticalStrut(10));
        painelDireita.add(tentarBtn);

        // Posicionamento do painel na tela
        painelDireita.setBounds(290, 20, 220, 180); // Ajustado para caber tudo
        painelFundo.add(painelDireita);

        setVisible(true);
    }

    public void atualizarTela() {
        progressoLabel.setText(partida.getProgresso());
        tentativasLabel.setText("Tentativas restantes: " + partida.getTentativasRestantes()); // NOVO
    }

    public void mostrarAnimacaoErro() {
        List<Image> erroFrames = Utils.carregarFrames(
                new String[]{"/imagens/meninaForcaErroFinal.png"}
        );
        painelFundo.mudarFrames(erroFrames, 500);
    }

    public void mostrarAnimacaoVitoria() {
        List<Image> vitoriaFrames = Utils.carregarFrames(
                new String[]{
                        "/imagens/meninaForcaVitoriaFinal1.png",
                        "/imagens/meninaForcaVitoriaFinal2.png"
                }
        );
        painelFundo.mudarFrames(vitoriaFrames, 400);
    }

    public void voltarAnimacaoPadrao() {
        List<Image> framesPadrao = Utils.carregarFrames(
                new String[]{
                        "/imagens/meninaForcaPadraoFinal1.png",
                        "/imagens/meninaForcaPadraoFinal2.png"
                }
        );
        painelFundo.mudarFrames(framesPadrao, 500);
    }
}
