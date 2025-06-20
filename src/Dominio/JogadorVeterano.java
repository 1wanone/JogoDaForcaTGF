package Dominio;

public class JogadorVeterano extends Jogador {

    public JogadorVeterano() {
        this.tentativas = 4;
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
