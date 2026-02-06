package com.xmind.smartschool.services;

import com.xmind.smartschool.dao.impl.EvaluationDAOImpl;
import com.xmind.smartschool.dao.interfaces.IEvaluationDAO;
import com.xmind.smartschool.models.entity.Evaluation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EvaluationService {
    private final IEvaluationDAO evaluationDAO;

    public EvaluationService() {
        this.evaluationDAO = new EvaluationDAOImpl();
    }

    public void createEvaluation(Evaluation evaluation) {
        if (evaluation.getId() == null || evaluation.getId().isEmpty()) {
            evaluation.setId(UUID.randomUUID().toString());
        }
        evaluationDAO.save(evaluation);
    }

    public List<Evaluation> getEvaluationsByMatiere(String matiereId) {
        return evaluationDAO.findByMatiereId(matiereId);
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationDAO.findAll();
    }

    public Optional<Evaluation> getEvaluationById(String id) {
        return evaluationDAO.findById(id);
    }
}
