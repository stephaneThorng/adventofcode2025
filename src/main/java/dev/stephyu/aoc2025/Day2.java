package dev.stephyu.aoc2025;

import java.util.HashSet;
import java.util.Set;

public class Day2 {
    public long partTwo(String input) {
        long result = 0;
        String[] ranges = input.split(",");
        for (String range : ranges) {
            String[] bounds = range.split("-");
            long left = Long.parseLong(bounds[0].trim());
            long right = Long.parseLong(bounds[1].trim());
            for (long i = left; i <= right; i++) {
                if (isInvalidID(i)) {
                    result += i;
                }
            }
        }
        return result;
    }

    private int numberOfDigits(long number) {
        return (int) Math.log10(number) + 1;
    }

    private boolean isInvalidID(long number) {
        int nbDigit = numberOfDigits(number);
        String s = String.valueOf(number);

        for (int nbPart = 2; nbPart <= nbDigit; nbPart++) {
            if (nbDigit % nbPart == 0) {
                int partSize = nbDigit / nbPart;
                Set<String> parts = new HashSet<>();

                for (int i = 0; i < nbPart; i++) {
                    parts.add(s.substring(i * partSize, (i + 1) * partSize));
                }

                if (parts.size() == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
