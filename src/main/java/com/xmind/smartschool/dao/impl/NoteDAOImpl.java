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
