package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCAPITALS {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/input.txt";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(outPath)) {

            String line;
            while (reader.ready()) {
                line = reader.readLine();
                out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
