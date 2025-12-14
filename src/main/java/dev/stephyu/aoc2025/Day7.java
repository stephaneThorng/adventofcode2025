package dev.stephyu.aoc2025;

import java.util.Arrays;

public class Day7 {

    public static final char SYMBOL_START = 'S';
    public static final char SYMBOL_TACHYON = '|';
    public static final char SYMBOL_SPLITTER = '^';


    public long partOne(String input) {
        String[] lines = input.split("\\r?\\n");
        int nbItem = lines[0].length();
        int nbLine = lines.length;
        char[][] grid = new char[nbLine][nbItem];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbItem; j++) {
                grid[i][j] = lines[i].charAt(j);
            }
        }

        long result = 0;
        
        grid[1][lines[0].indexOf(SYMBOL_START)] = SYMBOL_TACHYON;

        for (int i = 1; i < nbLine - 1; i++) {
            for (int j = 0; j < nbItem - 1; j++) {
                if (grid[i][j] == SYMBOL_TACHYON) {
                    if (grid[i + 1][j] == SYMBOL_SPLITTER) {
                        grid[i + 1][j - 1] = SYMBOL_TACHYON;
                        grid[i + 1][j + 1] = SYMBOL_TACHYON;
                        result++;
                    } else {
                        grid[i + 1][j] = SYMBOL_TACHYON;
                    }
                }
            }
        }

        return result;
    }

    public long partTwo(String input) {
        String[] lines = input.split("\\r?\\n");
        int nbItem = lines[0].length();
        int nbLine = lines.length;
        char[][] grid = new char[nbLine][nbItem];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbItem; j++) {
                grid[i][j] = lines[i].charAt(j);
            }
        }

        long[] timelines = new long[nbLine];
        timelines[lines[0].indexOf(SYMBOL_START)] = 1;

        for (int i = 1; i < nbLine - 1; i++) {
            long[] newTimeline = new long[nbLine];
            for (int j = 0; j < nbItem; j++) {
                if (timelines[j] == 0) continue;
                if (grid[i + 1][j] == SYMBOL_SPLITTER) {
                    newTimeline[j - 1] += timelines[j];
                    newTimeline[j + 1] += timelines[j];
                } else {
                    newTimeline[j] += timelines[j];
                }
            }
            timelines = newTimeline;
        }
        return Arrays.stream(timelines).sum();
    }
}