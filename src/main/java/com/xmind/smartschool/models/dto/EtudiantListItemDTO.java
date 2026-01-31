package com.xmind.smartschool.models.dto;

public class EtudiantListItemDTO {
    public enum Statut {
        ACTIF,
        INACTIF,
        SUSPENDU
    }

    private String matricule;
    private String nomPrenom;
    private String moyenneAnnuelle;
    private Statut statut;

    public EtudiantListItemDTO() {
    }

    /*
     * Constructor to create a new EtudiantListItemDTO object.
     */
    public EtudiantListItemDTO(String matricule, String nomPrenom, String moyenneAnnuelle, Statut statut) {
        this.matricule = matricule;
        this.nomPrenom = nomPrenom;
        this.moyenneAnnuelle = moyenneAnnuelle;
        this.statut = statut;
    }

    /*
     * Getters & Setters
     */
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getMoyenneAnnuelle() {
        return moyenneAnnuelle;
    }

    public void setMoyenneAnnuelle(String moyenneAnnuelle) {
        this.moyenneAnnuelle = moyenneAnnuelle;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /*
     * toString method to print the object.
     */
    @Override
    public String toString() {
        return "EtudiantListItemDTO [matricule=" + matricule
                + ", nomPrenom=" + nomPrenom
                + ", moyenneAnnuelle=" + moyenneAnnuelle
                + ", statut=" + statut
                + "]";
    }

}
