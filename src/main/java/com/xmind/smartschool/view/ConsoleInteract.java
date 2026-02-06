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
    public static int readInt(String prompt) {
        System.out.print(TerminalStyle.GREEN + "➜ " + prompt + ": " + TerminalStyle.RESET);
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
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
