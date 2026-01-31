package com.xmind.smartschool.models.entity;

import java.time.LocalDate;

public class Note {
    private Long id;
    private Double valeur;
    private String commentaire;
    private LocalDate dateSaisie;
    private Long etudiantId;
    private Long evaluationId;

    public Note() {
    }

    public Note(Long id, Double valeur, String commentaire, LocalDate dateSaisie, Long etudiantId, Long evaluationId) {
        this.id = id;
        this.valeur = valeur;
        this.commentaire = commentaire;
        this.dateSaisie = dateSaisie;
        this.etudiantId = etudiantId;
        this.evaluationId = evaluationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
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