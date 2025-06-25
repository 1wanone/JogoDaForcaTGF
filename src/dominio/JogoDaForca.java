package dominio;

public class JogoDaForca {
    private Jogador jogadorAtual;
    private Partida partidaAtual;

    public void iniciarPartida(Tema tema, Palavra palavra, Jogador jogador) {
        this.jogadorAtual = jogador;
        this.partidaAtual = new Partida(tema, palavra, jogador);
    }

    public Partida getPartidaAtual() {
        return partidaAtual;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
}
