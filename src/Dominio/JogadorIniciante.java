package Dominio;

public class JogadorIniciante extends Jogador {

    public JogadorIniciante() {
      super(6);
    }

    @Override
    public boolean tentarLetra(char letra, Partida partida) {
        boolean acertou = partida.getPalavra().verificaLetra(letra);
        if (!acertou) {
            tentativas--;
        }
        return acertou;
    }
}
