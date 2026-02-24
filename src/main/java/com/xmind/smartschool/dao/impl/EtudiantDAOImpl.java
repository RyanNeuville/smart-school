package com.xmind.smartschool.dao.impl;

import com.xmind.smartschool.config.DatabaseConnection;
import com.xmind.smartschool.dao.interfaces.IEtudiantDAO;
import com.xmind.smartschool.models.entity.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of IEtudiantDAO using JDBC.
 */
public class EtudiantDAOImpl implements IEtudiantDAO {

    @Override
    public Optional<Etudiant> findByMatricule(String matricule) {
        String query = "SELECT * FROM etudiants WHERE matricule = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, matricule);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToEtudiant(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding etudiant by matricule: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiants";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                etudiants.add(mapResultSetToEtudiant(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error finding all etudiants: " + e.getMessage());
            e.printStackTrace();
        }
        return etudiants;
    }

    @Override
    public void save(Etudiant etudiant) {
        String query = "INSERT INTO etudiants (id, matricule, nom, prenom, date_naissance, email, telephone, statut) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, etudiant.getId());
            pstmt.setString(2, etudiant.getMatricule());
            pstmt.setString(3, etudiant.getNom());
            pstmt.setString(4, etudiant.getPrenom());

            if (etudiant.getDateNaissance() != null) {
                pstmt.setDate(5, java.sql.Date.valueOf(etudiant.getDateNaissance()));
            } else {
                pstmt.setDate(5, null);
            }

            pstmt.setString(6, etudiant.getEmail());
            pstmt.setString(7, etudiant.getTelephone());

            if (etudiant.getStatut() != null) {
                pstmt.setString(8, etudiant.getStatut().name());
            } else {
                pstmt.setString(8, "ACTIF"); // Default
            }

            pstmt.executeUpdate();
            System.out.println("Etudiant saved successfully!");
        } catch (SQLException e) {
            System.err.println("Error saving etudiant: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Etudiant mapResultSetToEtudiant(ResultSet rs) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(rs.getString("id"));
        etudiant.setMatricule(rs.getString("matricule"));
        etudiant.setNom(rs.getString("nom"));
        etudiant.setPrenom(rs.getString("prenom"));

        java.sql.Date dateNaissance = rs.getDate("date_naissance");
        if (dateNaissance != null) {
            etudiant.setDateNaissance(dateNaissance.toLocalDate());
        }

        etudiant.setEmail(rs.getString("email"));
        etudiant.setTelephone(rs.getString("telephone"));

        Timestamp dateInscription = rs.getTimestamp("date_inscription");
        if (dateInscription != null) {
            etudiant.setDateInscription(dateInscription.toLocalDateTime());
        }

        String statutStr = rs.getString("statut");
        if (statutStr != null) {
            try {
                etudiant.setStatut(Etudiant.Statut.valueOf(statutStr));
            } catch (IllegalArgumentException e) {
                // Handle unknown status or default
                etudiant.setStatut(Etudiant.Statut.INACTIF);
            }
        }

        return etudiant;
    }
}
