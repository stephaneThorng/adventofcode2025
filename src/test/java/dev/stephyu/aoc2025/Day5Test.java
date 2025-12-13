package dev.stephyu.aoc2025;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {

    private static Stream<Arguments> partOneArgs() {
        return Stream.of(
                Arguments.of("day5_sample.txt", 3L),
                Arguments.of("day5_puzzle.txt", 701L)
        );
    }

    @ParameterizedTest
    @MethodSource("partOneArgs")
    void should_return_against_input_file_part_one(String filePath, long expected) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filePath)).toURI());
        Stream<String> lines = Files.lines(path);
        String content = lines.collect(Collectors.joining("\n"));
        lines.close();

        assertEquals(expected, new Day5().partOne(content));
    }

    private static Stream<Arguments> partTwoArgs() {
        return Stream.of(
                Arguments.of("day5_sample.txt", 14L),
                Arguments.of("day5_puzzle.txt", 352340558684863L)
        );
    }

    @ParameterizedTest
    @MethodSource("partTwoArgs")
    void should_return_against_input_file_part_two(String filePath, long expected) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filePath)).toURI());
        Stream<String> lines = Files.lines(path);
        String content = lines.collect(Collectors.joining("\n"));
        lines.close();

        assertEquals(expected, new Day5().partTwo(content));
    }
}
