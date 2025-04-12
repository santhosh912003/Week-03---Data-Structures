import java.io.*;

public class FindingOccurence {
    public static void main(String[] args) {
        String targetWord = "java";
        int count = 0;

        try {
            FileReader fr = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Occurrences of '" + targetWord + "': " + count);
    }
}
