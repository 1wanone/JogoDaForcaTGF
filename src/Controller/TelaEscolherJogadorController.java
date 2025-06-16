package Controller;

import Dominio.JogadorIniciante;
import Dominio.JogadorVeterano;
import View.TelaEscolherJogador;

public class TelaEscolherJogadorController {

    public void mostrarTela() {
        new TelaEscolherJogador(this);
    }

    public void jogadorSelecionado(String tipoJogador) {
        if (tipoJogador.equals("Iniciante")) {
            TelaEscolherTemaController.setJogador(new JogadorIniciante());
        } else {
            TelaEscolherTemaController.setJogador(new JogadorVeterano());
        }
        new TelaEscolherTemaController().mostrarTela();

    }
}
