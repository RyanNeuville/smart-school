package com.xmind.smartschool.models.entity;

public class Evaluation {
    public enum EvaluationType {
        EXAMEN,
        DEVOIR,
        CONTROLE,
        PARTIEL,
        TRAVAUX_DIRIGES,
        TRAVAUX_PRATIQUES,
        AUTRE
    }

    private String id;
    private EvaluationType type;
    private Float poids;
    private Long matiereId;

    public Evaluation() {
    }

    public Evaluation(String id, EvaluationType type, Float poids, Long matiereId) {
        this.id = id;
        this.type = type;
        this.poids = poids;
        this.matiereId = matiereId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EvaluationType getType() {
        return type;
    }

    public void setType(EvaluationType type) {
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

    @Override
    public String toString() {
        return "Evaluation [id=" + id
                + ", type=" + type
                + ", poids=" + poids
                + ", matiereId=" + matiereId
                + "]";
    }
}
