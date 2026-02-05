package com.xmind.smartschool.dao.interfaces;

import com.xmind.smartschool.models.entity.Etudiant;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Student Data Access Object.
 */
public interface IEtudiantDAO {
    Optional<Etudiant> findByMatricule(String matricule);

    List<Etudiant> findAll();
}
