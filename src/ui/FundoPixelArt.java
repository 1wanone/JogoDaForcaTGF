package ui;

import javax.swing.*;
import java.awt.*;

public class FundoPixelArt extends JPanel {
    private final Image imagemFundo;

    public FundoPixelArt(String caminhoImagem) {
        this.imagemFundo = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            for (int x = 0; x < getWidth(); x += imagemFundo.getWidth(null)) {
                for (int y = 0; y < getHeight(); y += imagemFundo.getHeight(null)) {
                    g.drawImage(imagemFundo, x, y, this);
                }
            }
        }
    }
}
