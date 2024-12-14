import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


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

    // Solve method to calculate the total distance
    public static int solve(List<Integer> leftList, List<Integer> rightList) {
        // Placeholder for your implementation
		Collections.sort(leftList);
		Collections.sort(rightList);
		int  l = 0;
		int r = 0;
		int distance = 0;
		for (int i = 0; i<leftList.size(); i++){
			l = leftList.get(i);
			r = rightList.get(i);
			if (l<r) {
				distance += (r-l);
			}
			if (r<l) {
				distance += (l-r);
			}
			
		}
		
        return distance;
    }
}
