package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/input.txt";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(outPath)) {

            String line;
            int vowels = 0;
            int others = 0;
            int punctuation = 0;
            while (reader.ready()) {
                line = reader.readLine();
                for (char c : line.toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i'
                        || c == 'o' || c == 'u' ) {
                        vowels++;
                    }
                    else if (c == '!' || c == ',' || c == '.' || c == '?') {
                        punctuation++;
                    }
                    else if (c != ' ') {
                        others++;
                    }
                }
            }
            out.println("Vowels: " + vowels);
            out.println("Other symbols: " + others);
            out.println("Punctuation: " + punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
