package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {
    private int id;
    private String nome;
    private List<Palavra> palavras;

    public Tema(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.palavras = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Palavra> getPalavras() {
        return palavras;
    }

    public void adicionarPalavra(Palavra p) {
        palavras.add(p);
    }

    public Palavra sorteiaPalavra() {
        if (palavras.isEmpty()) {
            throw new IllegalStateException("Não há palavras disponíveis neste tema");
        }
        Random random = new Random();
        return palavras.get(random.nextInt(palavras.size()));
    }
}
