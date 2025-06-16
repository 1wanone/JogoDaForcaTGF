package Dominio;

public class JogadorVeterano extends Jogador {

    public JogadorVeterano() {
        this.tentativas = 5;
    }

    @Override
    public void jogar() {
        System.out.println("Jogador Veterano jogando...");
    }
}
