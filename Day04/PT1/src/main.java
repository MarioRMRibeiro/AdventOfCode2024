import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        // Read the input word search grid
        String input = new String(Files.readAllBytes(Paths.get("input.txt")));
        String[] lines = input.split("\n");
        char[][] grid = new char[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }

        String target = "XMAS";

        int count = findWordOccurrences(grid, target);

        System.out.println("Total occurrences of " + target + ": " + count);
    }

    public static int findWordOccurrences(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length();
        int count = 0;

        // Define all 8 possible directions (dx, dy)
        int[] dx = {0, 0, 1, -1, 1, -1, 1, -1}; 
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1}; 

        // Loop through each position in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check all directions from this position
                for (int direction = 0; direction < 8; direction++) {
                    int x = i, y = j;
                    int k;
                    for (k = 0; k < wordLength; k++) {
                        // Calculate new position
                        int nx = x + dx[direction] * k;
                        int ny = y + dy[direction] * k;

                        // Check bounds
                        if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] != word.charAt(k)) {
                            break;
                        }
                    }
                    // If we matched the entire word, increment the count
                    if (k == wordLength) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
