package com.xmind.smartschool;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Smart School...");

        com.xmind.smartschool.services.EtudiantService service = new com.xmind.smartschool.services.EtudiantService();
        com.xmind.smartschool.view.StudentProfileView view = new com.xmind.smartschool.view.StudentProfileView();

        // Hardcoded matricule for demonstration - In a real app, this would come from
        // args or user input
        String matriculeToCheck = "2024001";

        if (args.length > 0) {
            matriculeToCheck = args[0];
        }

        System.out.println("Fetching profile for matricule: " + matriculeToCheck);

        var profileOpt = service.getEtudiantProfile(matriculeToCheck);

        if (profileOpt.isPresent()) {
            view.displayStudent(profileOpt.get());
        } else {
            System.out.println("Student not found for matricule: " + matriculeToCheck);
            System.out.println("Please check the database or provide a valid matricule as an argument.");
        }
    }
}
