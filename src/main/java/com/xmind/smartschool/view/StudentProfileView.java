package com.xmind.smartschool.view;

import java.util.List;
import com.xmind.smartschool.models.dto.EtudiantProfileDTO;

public class StudentProfileView {

        public void displayStudent(EtudiantProfileDTO dto) {
                // Dynamic color selection based on status
                String statusColor = dto.getStatut() == EtudiantProfileDTO.Statut.ACTIF
                                ? TerminalStyle.GREEN
                                : TerminalStyle.RED;

                // Better ASCII Art
                List<String> logo = List.of(
                                TerminalStyle.CYAN + "      .---.      " + TerminalStyle.RESET,
                                TerminalStyle.BLUE + "     /     \\     " + TerminalStyle.RESET,
                                TerminalStyle.BLUE + "    |  O_O  |    " + TerminalStyle.RESET,
                                TerminalStyle.CYAN + "    /\\  ^  /\\    " + TerminalStyle.RESET,
                                TerminalStyle.CYAN + "   // \\___/ \\\\   " + TerminalStyle.RESET,
                                TerminalStyle.CYAN + "  WW   | |   WW  " + TerminalStyle.RESET,
                                TerminalStyle.CYAN + "       |_|       " + TerminalStyle.RESET,
                                "",
                                TerminalStyle.BOLD + "SMART SCHOOL v2.0" + TerminalStyle.RESET);

                List<String> infos = List.of(
                                TerminalStyle.BOLD + "PROFIL ÉTUDIANT" + TerminalStyle.RESET,
                                "-------------------",
                                TerminalStyle.CYAN + "Matricule : " + TerminalStyle.RESET + dto.getMatricule(),
                                TerminalStyle.CYAN + "Nom       : " + TerminalStyle.RESET + dto.getNomComplet(),
                                TerminalStyle.CYAN + "Statut    : " + statusColor + dto.getStatut()
                                                + TerminalStyle.RESET,
                                "",
                                TerminalStyle.BOLD + "PERFORMANCES" + TerminalStyle.RESET,
                                "-------------------",
                                TerminalStyle.CYAN + "Moyenne   : " + formatGrade(dto.getMoyenneGenerale()),
                                TerminalStyle.CYAN + "Rang      : " + TerminalStyle.YELLOW + dto.getRangPromo() + "ème"
                                                + TerminalStyle.RESET);

                new NeofetchEngine().render(logo, infos);
        }

        private String formatGrade(double grade) {
                if (grade >= 16)
                        return TerminalStyle.GREEN + TerminalStyle.BOLD + String.format("%.2f", grade) + " (Excellent)"
                                        + TerminalStyle.RESET;
                if (grade >= 14)
                        return TerminalStyle.GREEN + String.format("%.2f", grade) + " (Bien)" + TerminalStyle.RESET;
                if (grade >= 10)
                        return TerminalStyle.YELLOW + String.format("%.2f", grade) + " (Passable)"
                                        + TerminalStyle.RESET;
                return TerminalStyle.RED + String.format("%.2f", grade) + " (Insuffisant)" + TerminalStyle.RESET;
        }

        public void displayStudentList(List<com.xmind.smartschool.models.entity.Etudiant> students) {
                if (students.isEmpty()) {
                        System.out.println(TerminalStyle.YELLOW + "Aucun étudiant trouvé." + TerminalStyle.RESET);
                        return;
                }

                String[] headers = { "ID", "Matricule", "Nom", "Prénom", "Email" };
                List<String[]> rows = students.stream()
                                .map(e -> new String[] {
                                                (e.getId().length() > 8 ? e.getId().substring(0, 8) + "..."
                                                                : e.getId()),
                                                e.getMatricule(),
                                                e.getNom(),
                                                e.getPrenom(),
                                                e.getEmail()
                                })
                                .collect(java.util.stream.Collectors.toList());

                new TableRenderer().printTable("Liste des Étudiants", headers, rows);
        }
}
