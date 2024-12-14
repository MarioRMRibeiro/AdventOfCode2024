import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Load input
            List<String> input = Files.readAllLines(Path.of("D:/ADVENTOFCODE2024/input.txt"));

            // Parse the input into two lists of integers
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();

            for (String line : input) {
                String[] parts = line.split("\\s+");
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
            }

            // Call the solve method (you will implement this logic)
            int totalDistance = solve(leftList, rightList);

            // Print the result
            System.out.println("Total distance: " + totalDistance);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    // Solve method to calculate the similarity
    public static int solve(List<Integer> leftList, List<Integer> rightList) {
        // Step 1: Create a frequency map for rightList
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : rightList) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		// Step 2: Calculate the similarity score
		int similarityScore = 0;
		for (int num : leftList) {
			int count = frequencyMap.getOrDefault(num, 0); // Frequency of num in rightList
			similarityScore += num * count;
		}

		return similarityScore;
    }
}
