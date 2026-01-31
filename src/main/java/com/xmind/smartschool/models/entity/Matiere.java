package com.xmind.smartschool.models.entity;

public class Matiere {
    private Long id;
    private String code;
    private String libelle;
    private String coefficient;
    private String description;

    public Matiere() {
    }

    public Matiere(Long id, String code, String libelle, String coefficient, String description) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.coefficient = coefficient;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
