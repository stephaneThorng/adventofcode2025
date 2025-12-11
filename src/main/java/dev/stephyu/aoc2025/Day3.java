package dev.stephyu.aoc2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    public static final int JOLTAGE_LENGTH = 12;

    public long play(String input) {
        String[] lines = input.split("\\r?\\n");
        long outputJoltage = 0;
        for (String line : lines) {
            long[] batteries = line.chars().mapToLong(c -> c - '0').toArray();
            long joltage = largestJoltage(batteries);
            outputJoltage += joltage;
        }
        return outputJoltage;
    }

    private long largestJoltage(long[] batteries) {
        return largestJoltage(batteries, new ArrayList<>());
    }

    private long largestJoltage(long[] batteries, List<Long> joltages) {
        int offset = 0;
        int lastIndex = batteries.length - JOLTAGE_LENGTH + joltages.size();
        for (int i = 1; i < lastIndex + 1; i++) {
            if (batteries[i] > batteries[offset]) {
                offset = i;
            }
        }
        joltages.add(batteries[offset]);
        if (joltages.size() == JOLTAGE_LENGTH) {
            return joltages.stream().mapToLong(Long::longValue).reduce(0, (a, b) -> a * 10 + b);
        }
        return largestJoltage(Arrays.stream(batteries, offset + 1, batteries.length).toArray(), joltages);
    }
}
