package dev.stephyu.aoc2025;

public class Day6 {

    public long partOne(String input) {
        String[] lines = input.split("\\r?\\n");
        int nbItems = lines.length - 1;
        int nbOperations = lines[nbItems].replace(" ", "").length();
        long[][] operations = new long[nbOperations][nbItems];

        for (int i = 0; i < nbItems; i++) {
            for (int j = 0; j < nbOperations; j++) {
                String[] split = lines[i].trim().split(" +");
                operations[j][i] = Long.parseLong(split[j]);
            }
        }

        long result = 0;

        String[] signs = lines[nbItems].replace(" ", "").split("");
        for (int i = 0; i < nbOperations; i++) {
            long totalPerColumn = switch (signs[i]) {
                case "+" -> 0;
                case "*" -> 1;
                default -> throw new IllegalStateException("Unexpected value: " + signs[i]);
            };

            for (int j = 0; j < nbItems; j++) {
                switch (signs[i]) {
                    case "+" -> totalPerColumn += operations[i][j];
                    case "*" -> totalPerColumn *= operations[i][j];
                    default -> throw new IllegalStateException("Unexpected value: " + signs[i]);
                }
            }
            result += totalPerColumn;
        }
        return result;
    }

    public long partTwo(String input) {
        String[] lines = input.split("\\r?\\n");

        long result = 0;
        long totalPerColumn = 0;
        char operator = '+';
        for (int offset = 0; offset < lines[0].length(); offset++) {

            char sign = lines[lines.length - 1].charAt(offset);
            if (sign != ' ') {
                operator = sign;
                result += totalPerColumn;
                totalPerColumn = switch (operator) {
                    case '+' -> 0;
                    case '*' -> 1;
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                };
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lines.length - 1; j++) {
                sb.append(lines[j].charAt(offset));
            }
            if (sb.toString().trim().isEmpty()) {
                continue;
            }
            long value = Long.parseLong(sb.toString().trim());

            switch (operator) {
                case '+' -> totalPerColumn += value;
                case '*' -> totalPerColumn *= value;
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            }
        }
        return result + totalPerColumn;
    }
}
