package com.xmind.smartschool;

/**
 * Main application class.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Starting Smart School Dashboard...");
        com.xmind.smartschool.view.DashboardView dashboard = new com.xmind.smartschool.view.DashboardView();
        dashboard.showMainMenu();
        com.xmind.smartschool.view.ConsoleInteract.close();
    }
}
