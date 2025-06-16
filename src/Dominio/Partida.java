package Dominio;

public class Partida {
    private Tema tema;
    private Palavra palavra;
    private Jogador jogador;
    private int erros = 0;

    public Partida(Tema tema, Palavra palavra, Jogador jogador) {
        this.tema = tema;
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public void tentativa(char letra) {
        if (!palavra.verificaLetra(letra)) {
            erros++;
        }
    }

    public boolean venceu() {
        return palavra.palavraCompleta();
    }

    public boolean terminou() {
        return venceu() || erros >= jogador.getTentativas();
    }

    public String getProgresso() {
        return palavra.mostraProgresso();
    }

    public int getErros() {
        return erros;
    }
}
