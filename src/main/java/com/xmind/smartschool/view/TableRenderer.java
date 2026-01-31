package com.xmind.smartschool.view;

import java.util.List;

/*
 * Table renderer class to print tables.
 */
public class TableRenderer {
    /*
     * Print table.
     */
    public void printTable(String title, String[] headers, List<String[]> rows) {
        System.out.println("\n" + TerminalStyle.BOLD + TerminalStyle.YELLOW + " » " + title + TerminalStyle.RESET);
        
        /* Separator */
        String hr = TerminalStyle.CYAN + "+------------+----------------------+-------+-----------+" + TerminalStyle.RESET;
        
        System.out.println(hr);
        /* Header formatted */
        System.out.printf(TerminalStyle.CYAN + "│ " + TerminalStyle.BLUE + "%-10s │ %-20s │ %-5s │ %-9s " + TerminalStyle.CYAN + "│\n", 
                          (Object[]) headers);
        System.out.println(hr);
        
        /* Data */
        for (String[] row : rows) {
            System.out.printf(TerminalStyle.CYAN + "│ " + TerminalStyle.RESET + "%-10s │ %-20s │ %-5s │ %-9s " + TerminalStyle.CYAN + "│\n", 
                              (Object[]) row);
        }
        System.out.println(hr);
    }
}
