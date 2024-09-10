package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String path1 = "src/StreamsFilesAndDirectories/Exercises Resources/inputOne.txt";
        String path2 = "src/StreamsFilesAndDirectories/Exercises Resources/inputTwo.txt";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/output.txt";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1));
             BufferedReader reader2 = new BufferedReader(new FileReader(path2));
             PrintWriter out = new PrintWriter(outPath)) {

            String line;
            while (reader1.ready()) {
                line = reader1.readLine();
                out.println(line);
            }
            while (reader2.ready()) {
                line = reader2.readLine();
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
