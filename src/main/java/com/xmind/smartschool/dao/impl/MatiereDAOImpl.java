package com.xmind.smartschool.dao.impl;

import com.xmind.smartschool.config.DatabaseConnection;
import com.xmind.smartschool.dao.interfaces.IMatiereDAO;
import com.xmind.smartschool.models.entity.Matiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of IMatiereDAO using JDBC.
 */
public class MatiereDAOImpl implements IMatiereDAO {

    @Override
    public void save(Matiere matiere) {
        String query = "INSERT INTO matieres (id, code, libelle, coefficient, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, matiere.getId());
            pstmt.setString(2, matiere.getCode());
            pstmt.setString(3, matiere.getLibelle());
            pstmt.setInt(4, matiere.getCoefficient());
            pstmt.setString(5, matiere.getDescription());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving matiere: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Matiere> findById(String id) {
        String query = "SELECT * FROM matieres WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToMatiere(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding matiere by id: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Matiere> findAll() {
        List<Matiere> matieres = new ArrayList<>();
        String query = "SELECT * FROM matieres";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                matieres.add(mapResultSetToMatiere(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error finding all matieres: " + e.getMessage());
            e.printStackTrace();
        }
        return matieres;
    }

    private Matiere mapResultSetToMatiere(ResultSet rs) throws SQLException {
        Matiere matiere = new Matiere();
        matiere.setId(rs.getString("id"));
        matiere.setCode(rs.getString("code"));
        matiere.setLibelle(rs.getString("libelle"));
        matiere.setCoefficient(rs.getInt("coefficient"));
        matiere.setDescription(rs.getString("description"));
        return matiere;
    }
}
