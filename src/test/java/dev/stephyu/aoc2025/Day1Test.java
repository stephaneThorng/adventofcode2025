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


class Day1Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("day1_sample.txt", 6),
                Arguments.of("day1_puzzle.txt", 5_820)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void should_return_against_input_file(String filePath, int expected) throws IOException, URISyntaxException {

        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filePath)).toURI());
        Stream<String> lines = Files.lines(path);
        String content = lines.collect(Collectors.joining("\n"));
        lines.close();

        assertEquals(expected, new Day1().play(content));
    }


}
