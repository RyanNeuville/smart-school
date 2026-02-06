package com.xmind.smartschool.services;

import com.xmind.smartschool.dao.impl.MatiereDAOImpl;
import com.xmind.smartschool.dao.interfaces.IMatiereDAO;
import com.xmind.smartschool.models.entity.Matiere;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MatiereService {
    private final IMatiereDAO matiereDAO;

    public MatiereService() {
        this.matiereDAO = new MatiereDAOImpl();
    }

    public void createMatiere(Matiere matiere) {
        if (matiere.getId() == null || matiere.getId().isEmpty()) {
            matiere.setId(UUID.randomUUID().toString());
        }
        matiereDAO.save(matiere);
    }

    public List<Matiere> getAllMatieres() {
        return matiereDAO.findAll();
    }

    public Optional<Matiere> getMatiereById(String id) {
        return matiereDAO.findById(id);
    }
}
