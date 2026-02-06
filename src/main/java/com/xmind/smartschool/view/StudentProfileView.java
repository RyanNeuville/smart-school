package com.xmind.smartschool.view;

import java.util.List;

import com.xmind.smartschool.models.dto.EtudiantProfileDTO;

/*
 * Student profile view class to display student profile.
 */
public class StudentProfileView {
        /*
         * Display student profile.
         */
        public void displayStudent(EtudiantProfileDTO dto) {
                List<String> logo = List.of("${AnsiColor.BRIGHT_BLUE}\n" + //
                                "  ██████  ███    ███  █████  ██████  ████████      \n" + //
                                " ██       ████  ████ ██   ██ ██   ██    ██         \n" + //
                                "  █████   ██ ████ ██ ███████ ██████     ██         \n" + //
                                "      ██  ██  ██  ██ ██   ██ ██   ██    ██         \n" + //
                                " ██████   ██      ██ ██   ██ ██   ██    ██         \n" + //
                                "${AnsiColor.CYAN}\n" + //
                                "  ██████  ██████ ██   ██  ██████   ██████  ██      \n" + //
                                " ██      ██      ██   ██ ██    ██ ██    ██ ██      \n" + //
                                "  █████  ██      ███████ ██    ██ ██    ██ ██      \n" + //
                                "      ██ ██      ██   ██ ██    ██ ██    ██ ██      \n" + //
                                "  ██████  ██████ ██   ██  ██████   ██████  ███████ \n" + //
                                "${AnsiColor.BRIGHT_WHITE}\n" + //
                                " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + //
                                "  ${AnsiColor.CYAN}🎓 SYSTÈME DE GESTION UNIVERSITAIRE v1.0\n" + //
                                "  ${AnsiColor.BRIGHT_BLUE}⚡ Spring Boot: ${spring-boot.version}\n" + //
                                " ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + //
                                "${AnsiColor.DEFAULT}\n" + //
                                "");

                List<String> infos = List.of(
                                TerminalStyle.CYAN + "USER: " + TerminalStyle.BOLD + dto.getNomComplet(),
                                TerminalStyle.CYAN + "MATRICULE: " + TerminalStyle.RESET + dto.getMatricule(),
                                TerminalStyle.CYAN + "MOYENNE: "
                                                + (dto.getMoyenneGenerale() >= 10 ? TerminalStyle.GREEN
                                                                : TerminalStyle.RED)
                                                + dto.getMoyenneGenerale(),
                                TerminalStyle.CYAN + "RANG: " + TerminalStyle.YELLOW + dto.getRangPromo() + "ème",
                                TerminalStyle.CYAN + "STATUT: " + TerminalStyle.RESET + dto.getStatut());

                new NeofetchEngine().render(logo, infos);
        }

        /**
         * Displays a list of students in a table format.
         * 
         * @param students The list of students to display.
         */
        public void displayStudentList(List<com.xmind.smartschool.models.entity.Etudiant> students) {
                if (students.isEmpty()) {
                        System.out.println(TerminalStyle.YELLOW + "Aucun étudiant trouvé." + TerminalStyle.RESET);
                        return;
                }

                String[] headers = { "ID", "Matricule", "Nom", "Prénom", "Email" };
                List<String[]> rows = students.stream()
                                .map(e -> new String[] {
                                                e.getId(),
                                                e.getMatricule(),
                                                e.getNom(),
                                                e.getPrenom(),
                                                e.getEmail()
                                })
                                .collect(java.util.stream.Collectors.toList());

                new TableRenderer().printTable("Liste des Étudiants", headers, rows);
        }
}
