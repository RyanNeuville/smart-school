package com.xmind.smartschool.dao.interfaces;

import com.xmind.smartschool.models.entity.Note;
import java.util.List;

/**
 * Interface for Note Data Access Object.
 */
public interface INoteDAO {
    List<Note> findByEtudiantId(String etudiantId);
}
