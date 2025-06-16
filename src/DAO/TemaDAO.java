package DAO;

import Dominio.Tema;
import Dominio.Palavra;

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
                Tema tema = new Tema(rs.getString("nome"));
                tema = carregarPalavrasDoTema(tema, rs.getInt("id"));
                temas.add(tema);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temas;
    }

    private Tema carregarPalavrasDoTema(Tema tema, int idTema) {
        PalavraDAO palavraDAO = new PalavraDAO();
        List<Palavra> palavras = palavraDAO.listarPalavrasPorTema(idTema);
        for (Palavra p : palavras) {
            tema.adicionarPalavra(p);
        }
        return tema;
    }
}
