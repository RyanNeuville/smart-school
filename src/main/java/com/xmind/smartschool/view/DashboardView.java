package com.xmind.smartschool.view;

import com.xmind.smartschool.models.entity.Etudiant;
import com.xmind.smartschool.models.entity.Evaluation;
import com.xmind.smartschool.models.entity.Matiere;
import com.xmind.smartschool.models.entity.Note;
import com.xmind.smartschool.services.EtudiantService;
import com.xmind.smartschool.services.EvaluationService;
import com.xmind.smartschool.services.MatiereService;
import com.xmind.smartschool.services.NoteService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class DashboardView {
    private final EtudiantService etudiantService = new EtudiantService();
    private final MatiereService matiereService = new MatiereService();
    private final EvaluationService evaluationService = new EvaluationService();
    private final NoteService noteService = new NoteService();
    private final StudentProfileView studentView = new StudentProfileView();

    public void showMainMenu() {
        boolean running = true;
        while (running) {
            ConsoleInteract.printHeader("DASHBOARD SMART SCHOOL");

            System.out.println(TerminalStyle.BOLD + "1." + TerminalStyle.RESET + " Gestion des Étudiants");
            System.out.println(TerminalStyle.BOLD + "2." + TerminalStyle.RESET + " Gestion des Matières");
            System.out.println(TerminalStyle.BOLD + "3." + TerminalStyle.RESET + " Gestion des Évaluations");
            System.out.println(TerminalStyle.BOLD + "4." + TerminalStyle.RESET + " Saisie des Notes");
            System.out.println(TerminalStyle.BOLD + "5." + TerminalStyle.RESET + " Quitter");
            System.out.println();

            int choice = ConsoleInteract.readInt("Votre choix");

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageSubjects();
                    break;
                case 3:
                    manageEvaluations();
                    break;
                case 4:
                    manageGrades();
                    break;
                case 5:
                    running = false;
                    System.out.println("\n" + TerminalStyle.GREEN + "Au revoir!" + TerminalStyle.RESET);
                    break;
                default:
                    System.out.println("\n" + TerminalStyle.RED + "Choix invalide." + TerminalStyle.RESET);
                    ConsoleInteract.pause();
            }
        }
    }

    private void manageStudents() {
        boolean back = false;
        while (!back) {
            ConsoleInteract.printHeader("GESTION ÉTUDIANTS");
            System.out.println("1. Lister les étudiants");
            System.out.println("2. Ajouter un étudiant");
            System.out.println("3. Rechercher un profil");
            System.out.println("4. Retour");
            System.out.println();

            int choice = ConsoleInteract.readInt("Votre choix");
            switch (choice) {
                case 1:
                    studentView.displayStudentList(etudiantService.getAllEtudiants());
                    ConsoleInteract.pause();
                    break;
                case 2:
                    formAddStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    back = true;
                    break;
            }
        }
    }

    private void formAddStudent() {
        ConsoleInteract.printHeader("NOUVEL ÉTUDIANT");
        Etudiant e = new Etudiant();
        e.setMatricule(ConsoleInteract.readString("Matricule"));
        e.setNom(ConsoleInteract.readString("Nom"));
        e.setPrenom(ConsoleInteract.readString("Prénom"));
        e.setEmail(ConsoleInteract.readString("Email"));
        e.setTelephone(ConsoleInteract.readString("Téléphone"));

        try {
            String dateStr = ConsoleInteract.readString("Date de naissance (YYYY-MM-DD)");
            e.setDateNaissance(LocalDate.parse(dateStr));
        } catch (DateTimeParseException ex) {
            System.out.println(TerminalStyle.RED + "Format de date invalide. Ignoré." + TerminalStyle.RESET);
        }

        e.setStatut(Etudiant.Statut.ACTIF);

        etudiantService.createEtudiant(e);
        System.out.println(TerminalStyle.GREEN + "\nÉtudiant créé avec succès!" + TerminalStyle.RESET);
        ConsoleInteract.pause();
    }

    private void searchStudent() {
        String matricule = ConsoleInteract.readString("Matricule");
        var profileOpt = etudiantService.getEtudiantProfile(matricule);
        if (profileOpt.isPresent()) {
            ConsoleInteract.clearScreen();
            studentView.displayStudent(profileOpt.get());
        } else {
            System.out.println(TerminalStyle.RED + "Introuvable." + TerminalStyle.RESET);
        }
        ConsoleInteract.pause();
    }

    private void manageSubjects() {
        boolean back = false;
        while (!back) {
            ConsoleInteract.printHeader("GESTION MATIÈRES");
            System.out.println("1. Lister les matières");
            System.out.println("2. Ajouter une matière");
            System.out.println("3. Retour");
            System.out.println();

            int choice = ConsoleInteract.readInt("Votre choix");
            switch (choice) {
                case 1:
                    listSubjects();
                    ConsoleInteract.pause();
                    break;
                case 2:
                    formAddSubject();
                    break;
                case 3:
                    back = true;
                    break;
            }
        }
    }

    private void listSubjects() {
        List<Matiere> matieres = matiereService.getAllMatieres();
        String[] headers = { "ID", "Code", "Libellé", "Coeff" };
        List<String[]> rows = matieres.stream()
                .map(m -> new String[] {
                        m.getId().substring(0, 8) + "...",
                        m.getCode(),
                        m.getLibelle(),
                        String.valueOf(m.getCoefficient())
                })
                .collect(java.util.stream.Collectors.toList());
        new TableRenderer().printTable("Liste des Matières", headers, rows);
    }

    private void formAddSubject() {
        ConsoleInteract.printHeader("NOUVELLE MATIÈRE");
        Matiere m = new Matiere();
        m.setCode(ConsoleInteract.readString("Code (ex: INFO101)"));
        m.setLibelle(ConsoleInteract.readString("Libellé"));
        m.setDescription(ConsoleInteract.readString("Description"));
        m.setCoefficient(ConsoleInteract.readInt("Coefficient"));

        matiereService.createMatiere(m);
        System.out.println(TerminalStyle.GREEN + "\nMatière créée avec succès!" + TerminalStyle.RESET);
        ConsoleInteract.pause();
    }

    private void manageEvaluations() {
        boolean back = false;
        while (!back) {
            ConsoleInteract.printHeader("GESTION ÉVALUATIONS");
            System.out.println("1. Lister les évaluations");
            System.out.println("2. Créer une évaluation");
            System.out.println("3. Retour");
            System.out.println();

            int choice = ConsoleInteract.readInt("Votre choix");
            switch (choice) {
                case 1:
                    listEvaluations();
                    ConsoleInteract.pause();
                    break;
                case 2:
                    formAddEvaluation();
                    break;
                case 3:
                    back = true;
                    break;
            }
        }
    }

    private void listEvaluations() {
        List<Evaluation> evals = evaluationService.getAllEvaluations();
        String[] headers = { "ID", "Type", "Poids", "Matiere ID" };
        List<String[]> rows = evals.stream()
                .map(e -> new String[] {
                        e.getId().substring(0, 8) + "...",
                        e.getType().name(),
                        String.valueOf(e.getPoids()),
                        e.getMatiereId() != null ? e.getMatiereId().substring(0, 8) + "..." : "N/A"
                })
                .collect(java.util.stream.Collectors.toList());
        new TableRenderer().printTable("Liste des Évaluations", headers, rows);
    }

    private void formAddEvaluation() {
        ConsoleInteract.printHeader("NOUVELLE ÉVALUATION");

        // Select Matiere first
        listSubjects();
        String matiereCode = ConsoleInteract.readString("Entrez le CODE de la matière");
        Optional<Matiere> matiereOpt = matiereService.getAllMatieres().stream()
                .filter(m -> m.getCode().equalsIgnoreCase(matiereCode))
                .findFirst();

        if (matiereOpt.isEmpty()) {
            System.out.println(TerminalStyle.RED + "Matière introuvable." + TerminalStyle.RESET);
            ConsoleInteract.pause();
            return;
        }

        Evaluation e = new Evaluation();
        e.setMatiereId(matiereOpt.get().getId());

        System.out.println("Types: EXAMEN, DEVOIR, PROJET...");
        String typeStr = ConsoleInteract.readString("Type d'évaluation").toUpperCase();
        try {
            e.setType(Evaluation.EvaluationType.valueOf(typeStr));
        } catch (IllegalArgumentException ex) {
            e.setType(Evaluation.EvaluationType.AUTRE);
        }

        // Read float properly
        e.setPoids(ConsoleInteract.readFloat("Poids (ex: 0.5)"));

        evaluationService.createEvaluation(e);
        System.out.println(TerminalStyle.GREEN + "\nÉvaluation créée avec succès!" + TerminalStyle.RESET);
        ConsoleInteract.pause();
    }

    private void manageGrades() {
        ConsoleInteract.printHeader("SAISIE DES NOTES");

        // 1. Find Student
        String matricule = ConsoleInteract.readString("Matricule de l'étudiant");
        // var etudiantOpt = etudiantService.getEtudiantProfile(matricule); // Removed
        // unused variable
        // Actually better to get Entity ID.
        var allStudents = etudiantService.getAllEtudiants();
        Optional<Etudiant> studentEntity = allStudents.stream().filter(s -> s.getMatricule().equals(matricule))
                .findFirst();

        if (studentEntity.isEmpty()) {
            System.out.println(TerminalStyle.RED + "Étudiant introuvable." + TerminalStyle.RESET);
            ConsoleInteract.pause();
            return;
        }

        // 2. Find Evaluation
        listEvaluations();
        String evalIdPart = ConsoleInteract.readString("ID de l'évaluation (premiers caractères suffisent)");
        var allEvals = evaluationService.getAllEvaluations();
        Optional<Evaluation> evalOpt = allEvals.stream().filter(ev -> ev.getId().startsWith(evalIdPart)).findFirst();

        if (evalOpt.isEmpty()) {
            System.out.println(TerminalStyle.RED + "Évaluation introuvable." + TerminalStyle.RESET);
            ConsoleInteract.pause();
            return;
        }

        // 3. Create Note
        Note note = new Note();
        note.setEtudiantId(studentEntity.get().getId());
        note.setEvaluationId(evalOpt.get().getId());
        note.setDateSaisie(LocalDate.now());

        note.setValeur(ConsoleInteract.readDouble("Note (0-20)"));
        note.setCommentaire(ConsoleInteract.readString("Commentaire"));

        noteService.createNote(note);
        System.out.println(TerminalStyle.GREEN + "\nNote enregistrée!" + TerminalStyle.RESET);
        ConsoleInteract.pause();
    }
}
