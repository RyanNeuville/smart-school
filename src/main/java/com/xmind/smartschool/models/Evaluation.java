package com.xmind.smartschool.models;

public class Evaluation {
    private Long id;
    private String type;
    private Float poids;
    private Long matiereId;
    private Long etudiantId;

    public Evaluation() {
    }

    public Evaluation(Long id, String type, Float poids, Long matiereId, Long etudiantId) {
        this.id = id;
        this.type = type;
        this.poids = poids;
        this.matiereId = matiereId;
        this.etudiantId = etudiantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public Long getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Long matiereId) {
        this.matiereId = matiereId;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    @Override
    public String toString() {
        return "Evaluation [id=" + id
                + ", type=" + type
                + ", poids=" + poids
                + ", matiereId=" + matiereId
                + ", etudiantId=" + etudiantId
                + "]";
    }
}
