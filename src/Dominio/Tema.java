package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {
    private String nome;
    private List<Palavra> palavras = new ArrayList<>();

    public Tema(String nome) {
        this.nome = nome;
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

    public void removerPalavra(Palavra p) {
        palavras.remove(p);
    }

    public Palavra sorteiaPalavra() {
        Random random = new Random();
        return palavras.get(random.nextInt(palavras.size()));
    }
}
