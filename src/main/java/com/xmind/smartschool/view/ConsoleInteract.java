package com.xmind.smartschool.view;

import java.util.Scanner;

/**
 * Utility class for handling console interactions, inputs, and standardized UI
 * elements.
 */
public class ConsoleInteract {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Clears the console screen using ANSI escape codes.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pauses execution until the user presses Enter.
     */
    public static void pause() {
        System.out.println("\n" + TerminalStyle.CYAN + "Press Enter to continue..." + TerminalStyle.RESET);
        scanner.nextLine();
    }

    /**
     * Displays a standardized header for menus and sections.
     * 
     * @param title The title to display
     */
    public static void printHeader(String title) {
        clearScreen();
        System.out.println(TerminalStyle.BOLD + TerminalStyle.BLUE + "=========================================="
                + TerminalStyle.RESET);
        System.out.println("   " + TerminalStyle.CYAN + title + TerminalStyle.RESET);
        System.out.println(TerminalStyle.BOLD + TerminalStyle.BLUE + "=========================================="
                + TerminalStyle.RESET);
        System.out.println();
    }

    /**
     * Reads a string input from the user with a prompt.
     * 
     * @param prompt The prompt to display
     * @return The user's input string
     */
    public static String readString(String prompt) {
        System.out.print(TerminalStyle.GREEN + "➜ " + prompt + ": " + TerminalStyle.RESET);
        return scanner.nextLine().trim();
    }

    /**
     * Reads an integer input from the user with a prompt.
     * Handles invalid input gracefully.
     * 
     * @param prompt The prompt to display
     * @return The user's input integer, or -1 if invalid
     */
    /**
     * Reads an integer input from the user with a prompt.
     * Retries until a valid integer is entered.
     * 
     * @param prompt The prompt to display
     * @return The user's input integer
     */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(TerminalStyle.GREEN + "➜ " + prompt + ": " + TerminalStyle.RESET);
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(TerminalStyle.RED + "   Erreur: Veuillez entrer un nombre entier valide."
                        + TerminalStyle.RESET);
            }
        }
    }

    /**
     * Reads a double input from the user with a prompt.
     * Retries until a valid double is entered.
     * 
     * @param prompt The prompt to display
     * @return The user's input double
     */
    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(TerminalStyle.GREEN + "➜ " + prompt + ": " + TerminalStyle.RESET);
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println(TerminalStyle.RED + "   Erreur: Veuillez entrer un nombre valide (ex: 12.5)."
                        + TerminalStyle.RESET);
            }
        }
    }

    /**
     * Reads a float input from the user with a prompt.
     * Retries until a valid float is entered.
     * 
     * @param prompt The prompt to display
     * @return The user's input float
     */
    public static float readFloat(String prompt) {
        while (true) {
            System.out.print(TerminalStyle.GREEN + "➜ " + prompt + ": " + TerminalStyle.RESET);
            try {
                String input = scanner.nextLine().trim();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println(TerminalStyle.RED + "   Erreur: Veuillez entrer un nombre valide (ex: 0.5)."
                        + TerminalStyle.RESET);
            }
        }
    }

    /**
     * Closes the scanner resource.
     * Should be called when the application exits.
     */
    public static void close() {
        scanner.close();
    }
}
