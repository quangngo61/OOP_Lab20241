import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "largefile.bin"; // Use absolute path if necessary
        StringBuilder outputStringBuilder = new StringBuilder();

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            long startTime = System.currentTimeMillis();

            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken (NoGarbage): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
