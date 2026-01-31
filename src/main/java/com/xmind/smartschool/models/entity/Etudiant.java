package com.xmind.smartschool.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Etudiant {
    public enum Statut {
        ACTIF,
        INACTIF,
        SUSPENDU
    }

    private String id;
    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;
    private String telephone;
    private LocalDateTime dateInscription;
    private Statut statut;

    public Etudiant() {
    }

    public Etudiant(String id, String matricule, String nom, String prenom, LocalDate dateNaissance, String email,
            String telephone, LocalDateTime dateInscription, Statut statut) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Etudiant [id=" + id
                + ", matricule=" + matricule
                + ", nom=" + nom
                + ", prenom=" + prenom
                + ", dateNaissance=" + dateNaissance
                + ", email=" + email
                + ", telephone=" + telephone
                + ", dateInscription=" + dateInscription
                + ", statut=" + statut
                + "]";
    }
}
