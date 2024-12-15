import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("input.txt")));

        Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)"); 
        Pattern doPattern = Pattern.compile("do\\(\\)");               
        Pattern dontPattern = Pattern.compile("don't\\(\\)");          

        Matcher mulMatcher = mulPattern.matcher(input);
        Matcher doMatcher = doPattern.matcher(input);
        Matcher dontMatcher = dontPattern.matcher(input);

        boolean mulEnabled = true;
        int totalSum = 0;

        Pattern combinedPattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)");
        Matcher combinedMatcher = combinedPattern.matcher(input);

        while (combinedMatcher.find()) {
            String match = combinedMatcher.group();

            if (match.startsWith("do()")) {
                // Enable mul instructions
                mulEnabled = true;
            } else if (match.startsWith("don't()")) {
                // Disable mul instructions
                mulEnabled = false;
            } else if (match.startsWith("mul(")) {
                // Process mul(X, Y) only if enabled
                if (mulEnabled) {
                    Matcher mul = mulPattern.matcher(match);
                    if (mul.find()) {
                        int x = Integer.parseInt(mul.group(1)); 
                        int y = Integer.parseInt(mul.group(2)); 
                        totalSum += x * y;                    
                    }
                }
            }
        }

        System.out.println("Total sum: " + totalSum);
    }
}
