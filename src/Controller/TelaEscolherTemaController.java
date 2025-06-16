package Controller;

import DAO.TemaDAO;
import Dominio.Jogador;
import Dominio.Tema;
import View.TelaEscolherTema;

import java.util.List;

public class TelaEscolherTemaController {
    private static Jogador jogador;

    public static void setJogador(Jogador j) {
        jogador = j;
    }

    public void mostrarTela() {
        List<Tema> temas = new TemaDAO().listarTemas();
        new TelaEscolherTema(this, temas);
    }

    public void temaSelecionado(Tema tema) {
        new TelaJogoController(jogador, tema).mostrarTela();
    }
}
