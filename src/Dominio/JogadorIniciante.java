package Dominio;

public class JogadorIniciante extends Jogador {

    public JogadorIniciante() {
        this.tentativas = 8;
    }

    @Override
    public void jogar() {
        System.out.println("Jogador Iniciante jogando...");
    }
}
