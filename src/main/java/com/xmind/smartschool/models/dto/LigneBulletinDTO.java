package com.xmind.smartschool.models.dto;

public class LigneBulletinDTO {
    private String codeMatiere;
    private String libelleMatiere;
    private int coefficient;
    private double noteObtenue;
    private double poidsTotal;
    private String appreciation;
    private boolean estValide;

    public LigneBulletinDTO() {
    }

    /*
     * Constructor to create a new LigneBulletinDTO object.
     */
    public LigneBulletinDTO(String codeMatiere, String libelleMatiere, int coefficient, double noteObtenue,
            double poidsTotal, String appreciation, boolean estValide) {
        this.codeMatiere = codeMatiere;
        this.libelleMatiere = libelleMatiere;
        this.coefficient = coefficient;
        this.noteObtenue = noteObtenue;
        this.poidsTotal = poidsTotal;
        this.appreciation = appreciation;
        this.estValide = estValide;
    }

    /*
     * Getters & Setters
     */
    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public double getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(double noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public double getPoidsTotal() {
        return poidsTotal;
    }

    public void setPoidsTotal(double poidsTotal) {
        this.poidsTotal = poidsTotal;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    /*
     * toString method to print the object.
     */
    @Override
    public String toString() {
        return "LigneBulletinDTO [codeMatiere=" + codeMatiere
                + ", libelleMatiere=" + libelleMatiere
                + ", coefficient=" + coefficient
                + ", noteObtenue=" + noteObtenue
                + ", poidsTotal=" + poidsTotal
                + ", appreciation=" + appreciation
                + ", estValide=" + estValide
                + "]";
    }

}
