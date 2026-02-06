package com.xmind.smartschool.dao.interfaces;

import com.xmind.smartschool.models.entity.Matiere;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Matiere Data Access Object.
 */
public interface IMatiereDAO {
    void save(Matiere matiere);

    Optional<Matiere> findById(String id);

    List<Matiere> findAll();
    // void update(Matiere matiere);
    // void delete(String id);
}
