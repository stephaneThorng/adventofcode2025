package dev.stephyu.aoc2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day5 {

    public long partOne(String input) {
        String[] lines = input.split("\\r?\\n");
        List<long[]> pairs = new ArrayList<>();
        boolean startProcessing = false;
        long result = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                startProcessing = true;
                continue;
            }

            if (startProcessing) {
                long number = Long.parseLong(line);
                for (long[] pair : pairs) {
                    if (number >= pair[0] && number <= pair[1]) {
                        result++;
                        break;
                    }
                }
            } else {
                String[] parts = line.split("-");
                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]);
                pairs.add(new long[]{start, end});
            }

        }

        return result;
    }

    public long partTwo(String input) {
        List<long[]> ranges = Arrays.stream(input.split("\\r?\\n"))
                .filter(l -> l.contains("-"))
                .map(l -> {
                    String[] parts = l.split("-");
                    return new long[]{Long.parseLong(parts[0]), Long.parseLong(parts[1])};
                })
                .sorted(Comparator.comparingLong(a -> a[0]))
                .toList();

        List<long[]> pairs = new ArrayList<>();

        for (long[] range : ranges) {
            if (pairs.isEmpty()) {
                pairs.add(new long[]{range[0], range[1]});
                continue;
            }
            long[] last = pairs.get(pairs.size() - 1);
            if (range[0] >= last[0] && range[0] <= last[1]) {
                if (range[1] > last[1]) {
                    last[1] = range[1];
                }
            } else {
                pairs.add(new long[]{range[0], range[1]});
            }
        }

        return pairs.stream().mapToLong(pair -> pair[1] - pair[0] + 1).sum();
    }
}
