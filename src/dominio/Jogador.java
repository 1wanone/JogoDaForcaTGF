package dominio;

public abstract class Jogador implements Jogavel {
    protected int tentativas;

    public Jogador(int tentativas) {
        this.tentativas = tentativas;
    }
    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
}
