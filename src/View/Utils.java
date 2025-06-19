package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Image carregarImagem(String caminho) {
        try (InputStream is = Utils.class.getResourceAsStream(caminho)) {
            if (is != null) {
                return ImageIO.read(is);
            } else {
                System.err.println("Imagem não encontrada: " + caminho);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Image> carregarFrames(String[] caminhos) {
        List<Image> frames = new ArrayList<>();
        for (String caminho : caminhos) {
            Image img = carregarImagem(caminho);
            if (img != null) {
                frames.add(img);
            }
        }
        return frames;
    }
}
