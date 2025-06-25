package dominio;

public class Partida {
    private Tema tema;
    private Palavra palavra;
    private Jogador jogador;

    public Partida(Tema tema, Palavra palavra, Jogador jogador) {
        this.tema = tema;
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public boolean tentativa(char letra) {
        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException("A tentativa deve ser uma letra do alfabeto");
        }
        return jogador.tentarLetra(letra, this);
    }


    public boolean venceu() {
        return palavra.palavraCompleta();
    }

    public boolean terminou() {
        return venceu() || jogador.getTentativas() <= 0;
    }

    public String getProgresso() {
        return palavra.mostraProgresso();
    }

    public int getTentativasRestantes() {
        return jogador.getTentativas();
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public Jogador getJogador() {
        return jogador;
    }
}
