package com.xmind.smartschool.models.dto;

public class EtudiantProfileDTO {
    public enum Statut {
        ACTIF,
        INACTIF,
        SUSPENDU
    }

    private String nomComplet;
    private String matricule;
    private String niveau;
    private int age;
    private Statut statut;
    private double moyenneGenerale;
    private String rangPromo;
    private int nombreAbsences;
    private String menttion;
    private String email;

    public EtudiantProfileDTO() {
    }

    public EtudiantProfileDTO(String nomComplet, String matricule, String niveau, int age, Statut statut,
            double moyenneGenerale, String rangPromo, int nombreAbsences, String menttion, String email) {
        this.nomComplet = nomComplet;
        this.matricule = matricule;
        this.niveau = niveau;
        this.age = age;
        this.statut = statut;
        this.moyenneGenerale = moyenneGenerale;
        this.rangPromo = rangPromo;
        this.nombreAbsences = nombreAbsences;
        this.menttion = menttion;
        this.email = email;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public double getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(double moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public String getRangPromo() {
        return rangPromo;
    }

    public void setRangPromo(String rangPromo) {
        this.rangPromo = rangPromo;
    }

    public int getNombreAbsences() {
        return nombreAbsences;
    }

    public void setNombreAbsences(int nombreAbsences) {
        this.nombreAbsences = nombreAbsences;
    }

    public String getMenttion() {
        return menttion;
    }

    public void setMenttion(String menttion) {
        this.menttion = menttion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EtudiantProfileDTO [nomComplet=" + nomComplet
                + ", matricule=" + matricule
                + ", niveau=" + niveau
                + ", age=" + age
                + ", statut=" + statut
                + ", moyenneGenerale=" + moyenneGenerale
                + ", rangPromo=" + rangPromo
                + ", nombreAbsences=" + nombreAbsences
                + ", menttion=" + menttion
                + ", email=" + email
                + "]";
    }

}