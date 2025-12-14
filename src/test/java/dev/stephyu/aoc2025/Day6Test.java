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

class Day6Test {

    private static Stream<Arguments> partOneArgs() {
        return Stream.of(
                Arguments.of("day6_sample.txt", 4277556L),
                Arguments.of("day6_puzzle.txt", 4076006202939L)
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

        assertEquals(expected, new Day6().partOne(content));
    }

    private static Stream<Arguments> partTwoArgs() {
        return Stream.of(
                Arguments.of("day6_sample.txt", 3263827L),
                Arguments.of("day6_puzzle.txt", 7903168391557L)
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

        assertEquals(expected, new Day6().partTwo(content));
    }
}
