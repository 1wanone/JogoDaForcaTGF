package Controller;

import DAO.TemaDAO;
import Dominio.Jogador;
import Dominio.Tema;
import View.TelaEscolherTema;

import java.util.List;

public class TelaEscolherTemaController {
    private final Jogador jogador;

    public TelaEscolherTemaController(Jogador jogador) {
        this.jogador = jogador;
    }

    public void mostrarTela() {
        List<Tema> temas = new TemaDAO().listarTemas();
        new TelaEscolherTema(this, temas);
    }

    public void temaSelecionado(Tema tema) {
        new TelaJogoController(jogador, tema).mostrarTela();
    }
}
