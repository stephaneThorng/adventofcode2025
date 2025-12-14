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

class Day7Test {

    private static Stream<Arguments> partOneArgs() {
        return Stream.of(
                Arguments.of("day7_sample.txt", 21L),
                Arguments.of("day7_puzzle.txt", 1535L)
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

        assertEquals(expected, new Day7().partOne(content));
    }

    private static Stream<Arguments> partTwoArgs() {
        return Stream.of(
                Arguments.of("day7_sample.txt", 40L),
                Arguments.of("day7_puzzle.txt", 4404709551015L)
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

        assertEquals(expected, new Day7().partTwo(content));
    }
}
