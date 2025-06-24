package Dominio;

public class Palavra {
    private String palavraSecreta;
    private char[] letrasCorretas;

    public Palavra(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta.toLowerCase();
        this.letrasCorretas = new char[palavraSecreta.length()];
        for (int i = 0; i < letrasCorretas.length; i++) {
            letrasCorretas[i] = '_';
        }
    }

    public boolean verificaLetra(char letra) {
        boolean acerto = false;
        letra = Character.toLowerCase(letra);
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                letrasCorretas[i] = letra;
                acerto = true;
            }
        }
        return acerto;
    }

    public boolean palavraCompleta() {
        for (char c : letrasCorretas) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public String mostraProgresso() {
        StringBuilder progresso = new StringBuilder();
        for (char c : letrasCorretas) {
            progresso.append(c).append(' ');
        }
        return progresso.toString();
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }
}
