package Dominio;

public class JogadorIniciante extends Jogador {

    public JogadorIniciante() {
        this.tentativas = 8;
    }

    @Override
    public boolean tentarLetra(char letra, Partida partida) {
        boolean acertou = partida.getPalavra().verificaLetra(letra);
        if (!acertou) {
            tentativas--;
            // Exemplo: poderia exibir dica para iniciante aqui (se quiser)
        }
        return acertou;
    }
}
