package dev.stephyu.aoc2025;

public class Day4 {
    public static final char SYMBOL = '@';
    public static final char SYMBOL2 = 'X';
    public static final int ADJACENT_MAX = 4;

    public int partOne(String input) {
        String[] lines = input.split("\\r?\\n");

        int xLength = lines[0].length();
        int yLength = lines.length;
        char[][] grid = new char[xLength][yLength]; //x,y
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                grid[x][y] = lines[x].charAt(y);
            }
        }

        int result = 0;
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                if (grid[x][y] == SYMBOL && hasSufficientAdjacent(x, y, grid)) {
                    result++;
                }
            }
        }

        return result;
    }

    public int partTwo(String input) {
        String[] lines = input.split("\\r?\\n");

        int xLength = lines[0].length();
        int yLength = lines.length;
        char[][] grid = new char[xLength][yLength]; //x,y
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                grid[x][y] = lines[x].charAt(y);
            }
        }

        int result = 0;
        boolean hasChanged;
        do {
            hasChanged = false;
            for (int x = 0; x < xLength; x++) {
                for (int y = 0; y < yLength; y++) {
                    if (grid[x][y] == SYMBOL && hasSufficientAdjacent(x, y, grid)) {
                        grid[x][y] = SYMBOL2; // Mark as counted
                        result++;
                        hasChanged = true;
                    }
                }
            }
        } while (hasChanged);


        return result;
    }

    private boolean hasSufficientAdjacent(int x, int y, char[][] grid) {
        int count = 0;
        int xLength = grid[0].length;
        int yLength = grid.length;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < xLength && newY >= 0 && newY < yLength
                        && grid[newX][newY] == SYMBOL) {
                    count++;
                }
            }
        }
        return count < ADJACENT_MAX;
    }
}
