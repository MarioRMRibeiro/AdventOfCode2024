import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("input.txt")));
        String[] lines = input.split("\n");
        char[][] grid = new char[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }

        System.out.println("X-MAS Count: " + countXMAS(grid));
    }

    public static int countXMAS(char[][] grid) {
        int count = 0;

        // Traverse through the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Debug: Print current center being checked
                System.out.println("Checking position (" + i + ", " + j + ") as potential center of X-MAS");

                // Check for X-MAS at (i, j)
                if (isXMAS(grid, i, j)) {
                    System.out.println("X-MAS found with center at (" + i + ", " + j + ")");
                    count++;
                } else {
                    System.out.println("No X-MAS found at (" + i + ", " + j + ")");
                }
            }
        }

        return count;
    }

    public static boolean isXMAS(char[][] grid, int x, int y) {
        // Ensure (x, y) is the center of an X-MAS and within bounds
        if (!inBounds(grid, x, y) || grid[x][y] != 'A') {
            System.out.println("Position (" + x + ", " + y + ") is not a valid center (not an 'A' or out of bounds)");
            return false;
        }

        // Debug: Print status of diagonal checks
        System.out.println("Checking diagonals for center at (" + x + ", " + y + ")");

        boolean topLeft = inBounds(grid, x - 1, y - 1) && grid[x - 1][y - 1] == 'M';
        boolean topRight = inBounds(grid, x - 1, y + 1) && grid[x - 1][y + 1] == 'M';
        boolean bottomLeft = inBounds(grid, x + 1, y - 1) && grid[x + 1][y - 1] == 'M';
        boolean bottomRight = inBounds(grid, x + 1, y + 1) && grid[x + 1][y + 1] == 'M';
        int validDiagonals = 0; 

        if (topLeft && inBounds(grid, x + 1, y + 1) && grid[x + 1][y + 1] == 'S') {
            validDiagonals++;
        }
        if (topRight && inBounds(grid, x + 1, y - 1) && grid[x + 1][y - 1] == 'S') {
            validDiagonals++;
        }
        if (bottomLeft && inBounds(grid, x - 1, y + 1) && grid[x - 1][y + 1] == 'S') {
            validDiagonals++;
        }   
        if (bottomRight && inBounds(grid, x - 1, y - 1) && grid[x - 1][y - 1] == 'S') {
            validDiagonals++;
        }

        // Check if all diagonal conditions are satisfied
        return validDiagonals>=2;
    }

    public static boolean inBounds(char[][] grid, int x, int y) {
        boolean inBounds = x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
        if (!inBounds) {
            System.out.println("Position (" + x + ", " + y + ") is out of bounds");
        }
        return inBounds;
    }
}

