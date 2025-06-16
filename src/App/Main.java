package App;

import Controller.TelaEscolherJogadorController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaEscolherJogadorController().mostrarTela());
    }
}
