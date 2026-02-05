package com.xmind.smartschool.services;

import com.xmind.smartschool.dao.impl.EtudiantDAOImpl;
import com.xmind.smartschool.dao.impl.NoteDAOImpl;
import com.xmind.smartschool.dao.interfaces.IEtudiantDAO;
import com.xmind.smartschool.dao.interfaces.INoteDAO;
import com.xmind.smartschool.models.dto.EtudiantProfileDTO;
import com.xmind.smartschool.models.entity.Etudiant;
import com.xmind.smartschool.models.entity.Note;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Etudiant related operations.
 */
public class EtudiantService {

    private final IEtudiantDAO etudiantDAO;
    private final INoteDAO noteDAO;

    public EtudiantService() {
        this.etudiantDAO = new EtudiantDAOImpl();
        this.noteDAO = new NoteDAOImpl();
    }

    /**
     * Retrieves the profile of a student by their matricule.
     * 
     * @param matricule The matricule of the student.
     * @return Optional containing the profile DTO if found, empty otherwise.
     */
    public Optional<EtudiantProfileDTO> getEtudiantProfile(String matricule) {
        Optional<Etudiant> etudiantOpt = etudiantDAO.findByMatricule(matricule);

        if (etudiantOpt.isEmpty()) {
            return Optional.empty();
        }

        Etudiant etudiant = etudiantOpt.get();
        List<Note> notes = noteDAO.findByEtudiantId(etudiant.getId());

        EtudiantProfileDTO profile = new EtudiantProfileDTO();
        profile.setNomComplet(etudiant.getPrenom() + " " + etudiant.getNom());
        profile.setMatricule(etudiant.getMatricule());
        profile.setEmail(etudiant.getEmail());

        // Calculate age
        if (etudiant.getDateNaissance() != null) {
            profile.setAge(Period.between(etudiant.getDateNaissance(), LocalDate.now()).getYears());
        }

        // Map status
        if (etudiant.getStatut() != null) {
            try {
                profile.setStatut(EtudiantProfileDTO.Statut.valueOf(etudiant.getStatut().name()));
            } catch (IllegalArgumentException e) {
                profile.setStatut(EtudiantProfileDTO.Statut.INACTIF);
            }
        }

        // Calculate average
        double average = calculateAverage(notes);
        profile.setMoyenneGenerale(average);

        // Set hardcoded/mocked values for missing data
        profile.setNiveau("Licence 3"); // TODO: Fetch from inscription/classe
        profile.setRangPromo("5"); // TODO: Calculate rank
        profile.setNombreAbsences(2); // TODO: Fetch absences logic

        return Optional.of(profile);
    }

    private double calculateAverage(List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Note note : notes) {
            if (note.getValeur() != null) {
                sum += note.getValeur();
            }
        }
        return Math.round((sum / notes.size()) * 100.0) / 100.0;
    }
}
