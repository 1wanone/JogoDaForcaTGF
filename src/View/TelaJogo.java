package View;

import Controller.TelaJogoController;
import Dominio.Partida;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaJogo extends JFrame {
    private JLabel progressoLabel;
    private JTextField letraInput;
    private JButton tentarBtn;
    private Partida partida;
    private TelaJogoController controller;

    private AnimacaoGarota painelFundo;  // Agora o fundo é a garota inteira (com cenário)

    public TelaJogo(TelaJogoController controller, Partida partida) {
        this.controller = controller;
        this.partida = partida;

        setTitle("🎲 Jogo da Forca");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Carrega animação da garota padrão
        String[] framesPadrao = {"/imagens/meninaForcaPadraoFinal1.png", "/imagens/meninaForcaPadraoFinal2.png"};
        List<Image> framesIniciais = Utils.carregarFrames(framesPadrao);
        painelFundo = new AnimacaoGarota(framesIniciais, 500);
        painelFundo.setLayout(null);  // Para posicionar os botões no topo

        setContentPane(painelFundo);

        // Painel flutuante no topo direito
        JPanel painelDireita = new JPanel();
        painelDireita.setLayout(new GridLayout(3, 1, 5, 5));
        painelDireita.setOpaque(false);  // Transparente sobre o fundo animado

        progressoLabel = new JLabel(partida.getProgresso());
        progressoLabel.setFont(new Font("Courier New", Font.BOLD, 24));

        letraInput = new JTextField(2);
        letraInput.setFont(new Font("Arial", Font.BOLD, 24));

        tentarBtn = new JButton("✔ Tentar");
        tentarBtn.setFont(new Font("Arial", Font.BOLD, 20));
        tentarBtn.addActionListener(e -> {
            String texto = letraInput.getText().trim();
            if (!texto.isEmpty()) {
                char letra = texto.charAt(0);
                controller.processarTentativa(letra, this);
                letraInput.setText("");
            }
        });

        painelDireita.add(progressoLabel);
        painelDireita.add(letraInput);
        painelDireita.add(tentarBtn);

        // Posiciona o painel flutuante
        painelDireita.setBounds(550, 20, 220, 150);
        painelFundo.add(painelDireita);

        setVisible(true);
    }

    public void atualizarTela() {
        progressoLabel.setText(partida.getProgresso());
    }

    public void mostrarAnimacaoErro() {
        List<Image> erroFrames = Utils.carregarFrames(new String[]{"/imagens/meninaForcaErroFinal.png"});
        painelFundo.mudarFrames(erroFrames, 1000);
    }

    public void mostrarAnimacaoVitoria() {
        List<Image> vitoriaFrames = Utils.carregarFrames(new String[]{
                "/imagens/meninaForcaVitoriaFinal1.png", "/imagens/meninaForcaVitoriaFinal2.png"
        });
        painelFundo.mudarFrames(vitoriaFrames, 400);
    }

    public void voltarAnimacaoPadrao() {
        List<Image> framesPadrao = Utils.carregarFrames(new String[]{
                "/imagens/meninaForcaPadraoFinal1.png", "/imagens/meninaForcaPadraoFinal2.png"
        });
        painelFundo.mudarFrames(framesPadrao, 500);
    }
}
