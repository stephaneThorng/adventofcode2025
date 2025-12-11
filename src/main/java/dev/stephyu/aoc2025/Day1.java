package dev.stephyu.aoc2025;

public class Day1 {
    public static final int MIN = 0;
    public static final int MAX = 99;

    public int partTwo(String input) {
        String[] lines = input.split("\\r?\\n");
        int offset = 50;
        int password = 0;

        System.out.println("The dial starts by pointing at " + offset + ".");
        for (String line : lines) {
            int direction = line.charAt(0) == 'L' ? -1 : 1;
            int distance = Integer.parseInt(line.substring(1));
            for (int i = 0; i < distance; i++) {
                offset += direction;
                if (offset == MIN || offset > MAX) {
                    password++;
                    offset = MIN;
                } else if (offset < MIN) {
                    offset = MAX;
                }
            }
            System.out.println("The dial is rotated " + line + " to point at " + offset + ".");
        }

        return password;
    }
}
