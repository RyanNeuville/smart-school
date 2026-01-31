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
            String left = (i < asciiArt.size()) ? asciiArt.get(i) : " ".repeat(20);
            String right = (i < infoLines.size()) ? infoLines.get(i) : "";

            /* Print ASCII art and information */
            System.out.println(TerminalStyle.CYAN + left + "   " + TerminalStyle.RESET + right);
        }
    }
}
