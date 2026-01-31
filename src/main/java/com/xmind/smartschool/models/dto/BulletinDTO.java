package com.xmind.smartschool.models.dto;

import java.time.LocalDate;
import java.util.List;

public class BulletinDTO {
    private EtudiantProfileDTO etudiantInfo;
    private List<LigneBulletinDTO> lignes;
    private double totalPoints;
    private double totalCoefs;
    private double moyenneTrimestrielle;
    private String mention;
    private String decisionConseil;
    private LocalDate dateGeneration;

    public BulletinDTO() {
    }

    /*
     * Constructor to create a new BulletinDTO object.
     */
    public BulletinDTO(EtudiantProfileDTO etudiantInfo, List<LigneBulletinDTO> lignes, double totalPoints,
            double totalCoefs,
            double moyenneTrimestrielle, String mention, String decisionConseil, LocalDate dateGeneration) {
        this.etudiantInfo = etudiantInfo;
        this.lignes = lignes;
        this.totalPoints = totalPoints;
        this.totalCoefs = totalCoefs;
        this.moyenneTrimestrielle = moyenneTrimestrielle;
        this.mention = mention;
        this.decisionConseil = decisionConseil;
        this.dateGeneration = dateGeneration;
    }

    /*
     * Getters & Setters
     */
    public EtudiantProfileDTO getEtudiantInfo() {
        return etudiantInfo;
    }

    public void setEtudiantInfo(EtudiantProfileDTO etudiantInfo) {
        this.etudiantInfo = etudiantInfo;
    }

    public List<LigneBulletinDTO> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneBulletinDTO> lignes) {
        this.lignes = lignes;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public double getTotalCoefs() {
        return totalCoefs;
    }

    public void setTotalCoefs(double totalCoefs) {
        this.totalCoefs = totalCoefs;
    }

    public double getMoyenneTrimestrielle() {
        return moyenneTrimestrielle;
    }

    public void setMoyenneTrimestrielle(double moyenneTrimestrielle) {
        this.moyenneTrimestrielle = moyenneTrimestrielle;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getDecisionConseil() {
        return decisionConseil;
    }

    public void setDecisionConseil(String decisionConseil) {
        this.decisionConseil = decisionConseil;
    }

    public LocalDate getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(LocalDate dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    /*
     * toString method to print the object.
     */
    @Override
    public String toString() {
        return "BulletinDTO [etudiantInfo=" + etudiantInfo
                + ", lignes=" + lignes
                + ", totalPoints=" + totalPoints
                + ", totalCoefs=" + totalCoefs
                + ", moyenneTrimestrielle=" + moyenneTrimestrielle
                + ", mention=" + mention
                + ", decisionConseil=" + decisionConseil
                + ", dateGeneration=" + dateGeneration
                + "]";
    }

}
