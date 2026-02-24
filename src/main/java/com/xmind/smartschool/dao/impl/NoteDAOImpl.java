package com.xmind.smartschool.dao.impl;

import com.xmind.smartschool.config.DatabaseConnection;
import com.xmind.smartschool.dao.interfaces.INoteDAO;
import com.xmind.smartschool.models.entity.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of INoteDAO using JDBC.
 */
public class NoteDAOImpl implements INoteDAO {

    @Override
    public List<Note> findByEtudiantId(String etudiantId) {
        List<Note> notes = new ArrayList<>();
        String query = "SELECT * FROM notes WHERE etudiant_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, etudiantId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    notes.add(mapResultSetToNote(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding notes by etudiantId: " + e.getMessage());
            e.printStackTrace();
        }
        return notes;
    }

    @Override
    public void save(Note note) {
        String query = "INSERT INTO notes (id, valeur, commentaire, date_saisie, etudiant_id, evaluation_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, note.getId());

            if (note.getValeur() != null) {
                pstmt.setDouble(2, note.getValeur());
            } else {
                pstmt.setNull(2, java.sql.Types.DECIMAL);
            }

            pstmt.setString(3, note.getCommentaire());

            if (note.getDateSaisie() != null) {
                // Conversion from LocalDate to Timestamp for compatibility with database.sql
                // (TIMESTAMP)
                // or just set Date if driver supports
                pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(note.getDateSaisie().atStartOfDay()));
            } else {
                pstmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            }

            pstmt.setString(5, note.getEtudiantId());
            pstmt.setString(6, note.getEvaluationId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving note: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Note mapResultSetToNote(ResultSet rs) throws SQLException {
        Note note = new Note();
        note.setId(rs.getString("id"));
        note.setValeur(rs.getDouble("valeur"));
        note.setCommentaire(rs.getString("commentaire"));

        java.sql.Date dateSaisie = rs.getDate("date_saisie");
        if (dateSaisie != null) {
            note.setDateSaisie(dateSaisie.toLocalDate());
        }

        note.setEtudiantId(rs.getString("etudiant_id"));
        note.setEvaluationId(rs.getString("evaluation_id"));

        return note;
    }
}
