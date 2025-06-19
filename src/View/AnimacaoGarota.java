package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AnimacaoGarota extends JPanel {
    private List<Image> frames;
    private int frameAtual = 0;
    private Timer timer;

    public AnimacaoGarota(List<Image> frames, int delayMillis) {
        this.frames = frames;
        timer = new Timer(delayMillis, e -> {
            frameAtual = (frameAtual + 1) % frames.size();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!frames.isEmpty()) {
            Image frame = frames.get(frameAtual);
            g.drawImage(frame, 0, 0, getWidth(), getHeight(), this);  // ESTICA a imagem do frame para ocupar todo o painel
        }
    }

    public void pararAnimacao() {
        if (timer != null) timer.stop();
    }

    public void iniciarAnimacao() {
        if (timer != null) timer.start();
    }

    public void mudarFrames(List<Image> novosFrames, int delayMillis) {
        pararAnimacao();
        this.frames = novosFrames;
        this.frameAtual = 0;
        timer = new Timer(delayMillis, e -> {
            frameAtual = (frameAtual + 1) % frames.size();
            repaint();
        });
        iniciarAnimacao();
    }
}
