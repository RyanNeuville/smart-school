package com.xmind.smartschool.models.entity;

import java.time.LocalDate;

public class Note {
    private String id;
    private Double valeur;
    private String commentaire;
    private LocalDate dateSaisie;
    private String etudiantId;
    private String evaluationId;

    public Note() {
    }

    public Note(String id, Double valeur, String commentaire, LocalDate dateSaisie, String etudiantId,
            String evaluationId) {
        this.id = id;
        this.valeur = valeur;
        this.commentaire = commentaire;
        this.dateSaisie = dateSaisie;
        this.etudiantId = etudiantId;
        this.evaluationId = evaluationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDate getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public String getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(String etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    @Override
    public String toString() {
        return "Note [id=" + id
                + ", valeur=" + valeur
                + ", commentaire=" + commentaire
                + ", dateSaisie=" + dateSaisie
                + ", etudiantId=" + etudiantId
                + ", evaluationId=" + evaluationId
                + "]";
    }
}