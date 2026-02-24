package com.xmind.smartschool.dao.interfaces;

import com.xmind.smartschool.models.entity.Evaluation;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Evaluation Data Access Object.
 */
public interface IEvaluationDAO {
    void save(Evaluation evaluation);

    Optional<Evaluation> findById(String id);

    List<Evaluation> findByMatiereId(String matiereId);

    List<Evaluation> findAll();
}
