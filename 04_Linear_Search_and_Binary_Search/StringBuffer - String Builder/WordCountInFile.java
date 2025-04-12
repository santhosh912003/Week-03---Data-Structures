import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) {
        String str = "HelloWorld";
        int iterations = 1000000;

        long startTimeBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTimeBuilder - startTimeBuilder) / 1000000 + " ms");

        long startTimeBuffer = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTimeBuffer - startTimeBuffer) / 1000000 + " ms");

        File file = new File("largefile.txt");
        try {
            FileReader fr = new FileReader(file);
            InputStreamReader isr = new InputStreamReader(fr);
            BufferedReader br = new BufferedReader(isr);

            String line;
            int wordCount = 0;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            br.close();
            System.out.println("Total words in the file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
