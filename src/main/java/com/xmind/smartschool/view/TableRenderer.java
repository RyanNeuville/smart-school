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
        if (headers == null || headers.length == 0)
            return;

        // Calculate column widths
        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = headers[i].length();
        }
        for (String[] row : rows) {
            for (int i = 0; i < row.length && i < colWidths.length; i++) {
                if (row[i] != null && row[i].length() > colWidths[i]) {
                    colWidths[i] = row[i].length();
                }
            }
        }

        // Add padding
        for (int i = 0; i < colWidths.length; i++) {
            colWidths[i] += 2; // 1 space padding on each side
        }

        System.out.println("\n" + TerminalStyle.BOLD + TerminalStyle.YELLOW + " » " + title + TerminalStyle.RESET);

        printSeparator(colWidths);
        printRow(headers, colWidths, TerminalStyle.BLUE);
        printSeparator(colWidths);

        for (String[] row : rows) {
            printRow(row, colWidths, TerminalStyle.RESET);
        }
        printSeparator(colWidths);
    }

    private void printSeparator(int[] colWidths) {
        StringBuilder sb = new StringBuilder();
        sb.append(TerminalStyle.CYAN).append("+");
        for (int width : colWidths) {
            sb.append("-".repeat(width)).append("+");
        }
        sb.append(TerminalStyle.RESET);
        System.out.println(sb.toString());
    }

    private void printRow(String[] row, int[] colWidths, String color) {
        StringBuilder sb = new StringBuilder();
        sb.append(TerminalStyle.CYAN).append("│");
        for (int i = 0; i < colWidths.length; i++) {
            String cell = (i < row.length && row[i] != null) ? row[i] : "";
            // Center alignment or Left alignment? Let's do Left with padding
            sb.append(color).append(String.format(" %-" + (colWidths[i] - 1) + "s", cell));
            sb.append(TerminalStyle.CYAN).append("│");
        }
        System.out.println(sb.toString());
    }
}
