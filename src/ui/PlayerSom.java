package ui;

import javax.sound.sampled.*;
import java.net.URL;

public class PlayerSom {
    private Clip clip;

    public void play(String caminho, boolean loop) {
        try {
            URL recurso = getClass().getResource(caminho);
            if (recurso == null) {
                System.err.println("Som não encontrado: " + caminho);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(recurso);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

            clip.start();
        } catch (Exception e) {
            System.err.println("Erro ao reproduzir o som: " + e.getMessage());
        }
    }

    public void parar() {
        if (clip != null) {
            if (clip.isRunning()) clip.stop();
            clip.close();
        }
    }
}
