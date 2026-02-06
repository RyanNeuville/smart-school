package com.xmind.smartschool.view;

import java.util.List;

/*
 * Neofetch engine class to render ASCII art and information.
 */
public class NeofetchEngine {
    /*
     * Render ASCII art and information.
     */
    public void render(List<String> asciiArt, List<String> infoLines) {
        int maxLines = Math.max(asciiArt.size(), infoLines.size());

        for (int i = 0; i < maxLines; i++) {
            // Get ASCII line or empty padding if out of bounds
            String left = (i < asciiArt.size()) ? asciiArt.get(i) : String.format("%-25s", " ");

            // Pad left side to ensure alignment if ascii lines vary in length (simple
            // approach: assuming fixed width or enough padding)
            // A better approach is to detect max width of ascii art, but for now we assume
            // the caller handles basic padding or we append spaces.
            // Using a fixed format for alignment:

            String right = (i < infoLines.size()) ? infoLines.get(i) : "";

            System.out.printf("%-30s %s%n", left, right);
        }
    }
}
