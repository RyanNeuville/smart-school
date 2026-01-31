package com.xmind.smartschool.models.dto;

public class DashboardStatsDTO {
    private int nombreTotalEtudiants;
    private int nombreEtudiantsActifs;
    private double moyenneDeLaPromo;
    private String topStudent;
    private String flopStudent;
    private double tauxReussite;
    private String nomBaseDeDonnees;

    public DashboardStatsDTO() {
    }

    public DashboardStatsDTO(int nombreTotalEtudiants, int nombreEtudiantsActifs, double moyenneDeLaPromo,
            String topStudent, String flopStudent, double tauxReussite, String nomBaseDeDonnees) {
        this.nombreTotalEtudiants = nombreTotalEtudiants;
        this.nombreEtudiantsActifs = nombreEtudiantsActifs;
        this.moyenneDeLaPromo = moyenneDeLaPromo;
        this.topStudent = topStudent;
        this.flopStudent = flopStudent;
        this.tauxReussite = tauxReussite;
        this.nomBaseDeDonnees = nomBaseDeDonnees;
    }

    public int getNombreTotalEtudiants() {
        return nombreTotalEtudiants;
    }

    public void setNombreTotalEtudiants(int nombreTotalEtudiants) {
        this.nombreTotalEtudiants = nombreTotalEtudiants;
    }

    public int getNombreEtudiantsActifs() {
        return nombreEtudiantsActifs;
    }

    public void setNombreEtudiantsActifs(int nombreEtudiantsActifs) {
        this.nombreEtudiantsActifs = nombreEtudiantsActifs;
    }

    public double getMoyenneDeLaPromo() {
        return moyenneDeLaPromo;
    }

    public void setMoyenneDeLaPromo(double moyenneDeLaPromo) {
        this.moyenneDeLaPromo = moyenneDeLaPromo;
    }

    public String getTopStudent() {
        return topStudent;
    }

    public void setTopStudent(String topStudent) {
        this.topStudent = topStudent;
    }

    public String getFlopStudent() {
        return flopStudent;
    }

    public void setFlopStudent(String flopStudent) {
        this.flopStudent = flopStudent;
    }

    public double getTauxReussite() {
        return tauxReussite;
    }

    public void setTauxReussite(double tauxReussite) {
        this.tauxReussite = tauxReussite;
    }

    public String getNomBaseDeDonnees() {
        return nomBaseDeDonnees;
    }

    public void setNomBaseDeDonnees(String nomBaseDeDonnees) {
        this.nomBaseDeDonnees = nomBaseDeDonnees;
    }

    @Override
    public String toString() {
        return "DashboardStatsDTO [nombreTotalEtudiants=" + nombreTotalEtudiants
                + ", nombreEtudiantsActifs=" + nombreEtudiantsActifs
                + ", moyenneDeLaPromo=" + moyenneDeLaPromo
                + ", topStudent=" + topStudent
                + ", flopStudent=" + flopStudent
                + ", tauxReussite=" + tauxReussite
                + ", nomBaseDeDonnees=" + nomBaseDeDonnees
                + "]";
    }

}
