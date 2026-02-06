package com.xmind.smartschool.dao.impl;

import com.xmind.smartschool.config.DatabaseConnection;
import com.xmind.smartschool.dao.interfaces.IEvaluationDAO;
import com.xmind.smartschool.models.entity.Evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of IEvaluationDAO using JDBC.
 */
public class EvaluationDAOImpl implements IEvaluationDAO {

    @Override
    public void save(Evaluation evaluation) {
        String query = "INSERT INTO evaluations (id, type_eval, poids, matiere_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, evaluation.getId());
            pstmt.setString(2, evaluation.getType().name());
            pstmt.setFloat(3, evaluation.getPoids());
            pstmt.setString(4, evaluation.getMatiereId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving evaluation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Evaluation> findById(String id) {
        String query = "SELECT * FROM evaluations WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToEvaluation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding evaluation by id: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Evaluation> findByMatiereId(String matiereId) {
        List<Evaluation> evaluations = new ArrayList<>();
        String query = "SELECT * FROM evaluations WHERE matiere_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, matiereId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    evaluations.add(mapResultSetToEvaluation(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding evaluations by matiereId: " + e.getMessage());
            e.printStackTrace();
        }
        return evaluations;
    }

    @Override
    public List<Evaluation> findAll() {
        List<Evaluation> evaluations = new ArrayList<>();
        String query = "SELECT * FROM evaluations";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                evaluations.add(mapResultSetToEvaluation(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error finding all evaluations: " + e.getMessage());
            e.printStackTrace();
        }
        return evaluations;
    }

    private Evaluation mapResultSetToEvaluation(ResultSet rs) throws SQLException {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(rs.getString("id"));
        try {
            evaluation.setType(Evaluation.EvaluationType.valueOf(rs.getString("type_eval")));
        } catch (IllegalArgumentException e) {
            evaluation.setType(Evaluation.EvaluationType.AUTRE);
        }
        evaluation.setPoids(rs.getFloat("poids"));
        evaluation.setMatiereId(rs.getString("matiere_id"));
        return evaluation;
    }
}
