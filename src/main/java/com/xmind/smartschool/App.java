package com.xmind.smartschool;

import com.xmind.smartschool.services.EtudiantService;
import com.xmind.smartschool.view.ConsoleInteract;
import com.xmind.smartschool.view.StudentProfileView;
import com.xmind.smartschool.view.TerminalStyle;

import java.util.Optional;

/**
 * Main application class.
 */
public class App {
    private static final EtudiantService etudiantService = new EtudiantService();
    private static final StudentProfileView studentView = new StudentProfileView();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            ConsoleInteract.printHeader("SMART SCHOOL MANAGEMENT SYSTEM");

            System.out.println(TerminalStyle.BOLD + "1." + TerminalStyle.RESET + " Lister tous les étudiants");
            System.out.println(TerminalStyle.BOLD + "2." + TerminalStyle.RESET + " Rechercher un étudiant (Matricule)");
            System.out.println(TerminalStyle.BOLD + "3." + TerminalStyle.RESET + " Quitter");
            System.out.println();

            int choice = ConsoleInteract.readInt("Votre choix");

            switch (choice) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    running = false;
                    System.out.println("\n" + TerminalStyle.GREEN + "Au revoir!" + TerminalStyle.RESET);
                    break;
                default:
                    System.out.println("\n" + TerminalStyle.RED + "Choix invalide." + TerminalStyle.RESET);
                    ConsoleInteract.pause();
            }
        }
        ConsoleInteract.close();
    }

    private static void listAllStudents() {
        ConsoleInteract.printHeader("LISTE DES ÉTUDIANTS");
        var students = etudiantService.getAllEtudiants();
        studentView.displayStudentList(students);
        ConsoleInteract.pause();
    }

    private static void searchStudent() {
        ConsoleInteract.printHeader("RECHERCHE ÉTUDIANT");
        String matricule = ConsoleInteract.readString("Entrez le matricule");

        System.out.println("\nRecherche en cours...");
        var profileOpt = etudiantService.getEtudiantProfile(matricule);

        if (profileOpt.isPresent()) {
            ConsoleInteract.clearScreen();
            studentView.displayStudent(profileOpt.get());
        } else {
            System.out.println("\n" + TerminalStyle.RED + "Aucun étudiant trouvé avec le matricule: " + matricule
                    + TerminalStyle.RESET);
        }
        ConsoleInteract.pause();
    }
}
