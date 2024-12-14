import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // Load input from a file
        int safeReports= 0;
        List<String> input = Files.readAllLines(Paths.get("input.txt"));
        for (String line : input) {
            List<Integer> levels = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            if (isSafe(levels)) {
                safeReports++;
            }
        }
        // Call solve method and print the result
        int result = safeReports;
        System.out.println("Number of safe reports: " + result);
    }

    public static boolean isSafe(List<Integer> levels) {
        // TODO: Implement logic to determine how many reports are safe
        boolean ascending = false;
        boolean descending = false;
        int current = 0;
        int next = 0;
        for(int i = 0; i<(levels.size()-1);i++){
            current = levels.get(i);
            next = levels.get(i+1);
            
            if (current==next){
                return false;
            }
            if (current<next){
                if ((next-current) >3){
                    return false;
                }
                ascending = true;
            }
            if (current>next){
                if ((current-next) >3){
                    return false;
                }
                descending = true;
            }
        }
        if (ascending && descending){
            return false;
        }
        return true; // Placeholder
    }
}