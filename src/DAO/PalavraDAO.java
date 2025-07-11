package DAO;

import dominio.Palavra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PalavraDAO {

    public List<Palavra> listarPalavrasPorTema(int idTema) {
        List<Palavra> palavras = new ArrayList<>();
        String sql = "SELECT palavra FROM palavra WHERE id_tema = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTema);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                palavras.add(new Palavra(rs.getString("palavra")));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar palavras para o tema ID " + idTema + ": " + e.getMessage());
        }

        return palavras;
    }
}
