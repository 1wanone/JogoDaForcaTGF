package Dominio;

public abstract class Jogador implements Jogavel {
    protected int tentativas;

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
}
