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

class Day4Test {

    private static Stream<Arguments> partOneArgs() {
        return Stream.of(
                Arguments.of("day4_sample.txt", 13),
                Arguments.of("day4_puzzle.txt", 1564)
        );
    }

    @ParameterizedTest
    @MethodSource("partOneArgs")
    void should_return_against_input_file_part_one(String filePath, int expected) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filePath)).toURI());
        Stream<String> lines = Files.lines(path);
        String content = lines.collect(Collectors.joining("\n"));
        lines.close();

        assertEquals(expected, new Day4().partOne(content));
    }

    private static Stream<Arguments> partTwoArgs() {
        return Stream.of(
                Arguments.of("day4_sample.txt", 43),
                Arguments.of("day4_puzzle.txt", 9401)
        );
    }

    @ParameterizedTest
    @MethodSource("partTwoArgs")
    void should_return_against_input_file_part_two(String filePath, int expected) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filePath)).toURI());
        Stream<String> lines = Files.lines(path);
        String content = lines.collect(Collectors.joining("\n"));
        lines.close();

        assertEquals(expected, new Day4().partTwo(content));
    }
}
