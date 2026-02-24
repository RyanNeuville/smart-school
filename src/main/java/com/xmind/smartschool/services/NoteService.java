package com.xmind.smartschool.services;

import com.xmind.smartschool.dao.impl.NoteDAOImpl;
import com.xmind.smartschool.dao.interfaces.INoteDAO;
import com.xmind.smartschool.models.entity.Note;

import java.util.List;
import java.util.UUID;

public class NoteService {
    private final INoteDAO noteDAO;

    public NoteService() {
        this.noteDAO = new NoteDAOImpl();
    }

    public void createNote(Note note) {
        if (note.getId() == null || note.getId().isEmpty()) {
            note.setId(UUID.randomUUID().toString());
        }
        noteDAO.save(note);
    }

    public List<Note> getNotesByEtudiant(String etudiantId) {
        return noteDAO.findByEtudiantId(etudiantId);
    }
}
