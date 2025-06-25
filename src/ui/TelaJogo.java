package ui;

import controller.TelaJogoController;
import dominio.Partida;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaJogo extends JFrame {
    private JTextArea progressoArea;
    private JLabel tentativasLabel;
    private JTextField letraInput;
    private JButton tentarBtn;
    private Partida partida;
    private TelaJogoController controller;
    private AnimacaoGarota painelFundo;

    private PlayerSom somFundo;
    private PlayerSom somErro;
    private PlayerSom somVitoria;

    public TelaJogo(TelaJogoController controller, Partida partida) {
        try {
            this.controller = controller;
            this.partida = partida;

            setTitle("🎲 Jogo da Forca");
            setSize(700, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            String[] framesPadrao = {
                    "/imagens/meninaForcaPadraoFinal1.png",
                    "/imagens/meninaForcaPadraoFinal2.png"
            };
            List<Image> framesIniciais = Utils.carregarFrames(framesPadrao);
            painelFundo = new AnimacaoGarota(framesIniciais, 500);
            painelFundo.setLayout(null);
            setContentPane(painelFundo);

            progressoArea = new JTextArea(partida.getProgresso());
            progressoArea.setFont(new Font("Courier New", Font.BOLD, 25));
            progressoArea.setForeground(Color.black);
            progressoArea.setBackground(new Color(0, 0, 0, 0));
            progressoArea.setEditable(false);
            progressoArea.setFocusable(false);
            progressoArea.setWrapStyleWord(true);
            progressoArea.setLineWrap(true);
            progressoArea.setOpaque(false);
            progressoArea.setBounds(150, 100, 400, 60);
            painelFundo.add(progressoArea);

            tentativasLabel = new JLabel("Tentativas: " + partida.getTentativasRestantes());
            tentativasLabel.setFont(new Font("Courier New", Font.BOLD, 20));
            tentativasLabel.setForeground(Color.black);
            tentativasLabel.setBounds(260, 170, 300, 30);
            painelFundo.add(tentativasLabel);

            letraInput = new JTextField(1);
            letraInput.setFont(new Font("Courier New", Font.BOLD, 28));
            letraInput.setBounds(270, 220, 60, 40);
            painelFundo.add(letraInput);

            tentarBtn = new JButton(new ImageIcon(getClass().getResource("/imagens/bntTentar.png")));
            Utils.estilizarBotaoPixel(tentarBtn);
            tentarBtn.setBounds(350, 220, 120, 40);
            tentarBtn.addActionListener(e -> {
                try {
                    String texto = letraInput.getText().trim();
                    if (!texto.isEmpty()) {
                        char letra = texto.charAt(0);
                        controller.processarTentativa(letra, this);
                        letraInput.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Digite uma letra!", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao processar tentativa: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });
            painelFundo.add(tentarBtn);

            somFundo = new PlayerSom();
            somFundo.play("/sons/fundo.wav", true);

            setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tela do jogo: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTela() {
        try {
            progressoArea.setText(partida.getProgresso());
            tentativasLabel.setText("Tentativas: " + partida.getTentativasRestantes());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar a tela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarAnimacaoErro() {
        try {
            somErro = new PlayerSom();
            somErro.play("/sons/erro.wav", false);
            List<Image> erroFrames = Utils.carregarFrames(
                    new String[]{"/imagens/meninaForcaErroFinal.png"}
            );
            painelFundo.mudarFrames(erroFrames, 500);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao exibir animação de erro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarAnimacaoVitoria() {
        try {
            somFundo.parar();
            somVitoria = new PlayerSom();
            somVitoria.play("/sons/vitoria.wav", false);
            List<Image> vitoriaFrames = Utils.carregarFrames(
                    new String[]{"/imagens/meninaForcaVitoriaFinal1.png", "/imagens/meninaForcaVitoriaFinal2.png"}
            );
            painelFundo.mudarFrames(vitoriaFrames, 400);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao exibir animação de vitória.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void voltarAnimacaoPadrao() {
        try {
            List<Image> framesPadrao = Utils.carregarFrames(
                    new String[]{"/imagens/meninaForcaPadraoFinal1.png", "/imagens/meninaForcaPadraoFinal2.png"}
            );
            painelFundo.mudarFrames(framesPadrao, 500);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao retornar à animação padrão.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
