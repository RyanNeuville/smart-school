package com.xmind.smartschool.models.entity;

/*
 * Entity class to represent a Matiere.
 */
public class Matiere {
    private String id;
    private String code;
    private String libelle;
    private String coefficient;
    private String description;

    /*
     * Constructors to create a new Matiere object.
     */
    public Matiere() {
    }

    public Matiere(String id, String code, String libelle, String coefficient, String description) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.coefficient = coefficient;
        this.description = description;
    }

    /*
     * Getters & Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * toString method to print the object.
     */
    @Override
    public String toString() {
        return "Matiere [id=" + id
                + ", code=" + code
                + ", libelle=" + libelle
                + ", coefficient=" + coefficient
                + ", description=" + description
                + "]";
    }
}
