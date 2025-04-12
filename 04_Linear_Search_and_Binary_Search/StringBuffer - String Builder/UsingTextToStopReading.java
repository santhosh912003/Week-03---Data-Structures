import java.io.*;

public class UsingTextToStopReading {
    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fileWriter = new FileWriter("output.txt", true); 
            BufferedWriter fileWriterBuffered = new BufferedWriter(fileWriter);
            
            String userInput;
            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                userInput = consoleReader.readLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                fileWriterBuffered.write(userInput);
                fileWriterBuffered.newLine();
            }

            fileWriterBuffered.close();
            consoleReader.close();
            System.out.println("Input written to file 'output.txt'.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
