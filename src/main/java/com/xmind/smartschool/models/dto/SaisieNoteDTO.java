package com.xmind.smartschool.models.dto;

import com.xmind.smartschool.models.entity.Evaluation.EvaluationType;

public class SaisieNoteDTO {
    private String matriculeEtudiant;
    private String codeMatiere;
    private EvaluationType typeEvaluation;
    private double valeurNote;
    private String commentaire;

    public SaisieNoteDTO() {
    }

    /*
     * Constructor to create a new SaisieNoteDTO object.
     */
    public SaisieNoteDTO(String matriculeEtudiant, String codeMatiere, EvaluationType typeEvaluation,
            double valeurNote, String commentaire) {
        this.matriculeEtudiant = matriculeEtudiant;
        this.codeMatiere = codeMatiere;
        this.typeEvaluation = typeEvaluation;
        this.valeurNote = valeurNote;
        this.commentaire = commentaire;
    }

    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public EvaluationType getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(EvaluationType typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public double getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(double valeurNote) {
        this.valeurNote = valeurNote;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /*
     * toString method to print the object.
     */
    @Override
    public String toString() {
        return "SaisieNoteDTO [matriculeEtudiant=" + matriculeEtudiant
                + ", codeMatiere=" + codeMatiere
                + ", typeEvaluation=" + typeEvaluation
                + ", valeurNote=" + valeurNote
                + ", commentaire=" + commentaire
                + "]";
    }
}
