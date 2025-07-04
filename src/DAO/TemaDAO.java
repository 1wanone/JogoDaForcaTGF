package DAO;

import dominio.Tema;
import dominio.Palavra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TemaDAO {

    public List<Tema> listarTemas() {
        List<Tema> temas = new ArrayList<>();
        String sql = "SELECT id, nome FROM tema";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tema tema = new Tema(rs.getInt("id"), rs.getString("nome"));
                carregarPalavrasDoTema(tema);
                temas.add(tema);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar temas: " + e.getMessage());
        }

        return temas;
    }

    private void carregarPalavrasDoTema(Tema tema) {
        PalavraDAO palavraDAO = new PalavraDAO();
        List<Palavra> palavras = palavraDAO.listarPalavrasPorTema(tema.getId());
        for (Palavra p : palavras) {
            tema.adicionarPalavra(p);
        }
    }
}
