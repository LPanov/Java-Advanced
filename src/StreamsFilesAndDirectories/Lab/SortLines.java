package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "src/StreamsFilesAndDirectories/input.txt";
        String pathOut = "src/StreamsFilesAndDirectories/06.SortLinesOutput.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(pathOut))) {
            Files.readAllLines(Paths.get(path))
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
