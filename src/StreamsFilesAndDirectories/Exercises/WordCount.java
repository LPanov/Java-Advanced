package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.Entry.comparingByValue;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/text.txt";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/results.txt";

        String[] input = new Scanner(Paths.get("src/StreamsFilesAndDirectories/Exercises Resources/words.txt")).nextLine().split("\\s+");
        Map<String, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            occurrences.put(input[i], 0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(outPath)) {

            String[] wordsInLine;
            while (reader.ready()) {
                wordsInLine = reader.readLine().split("\\s+");
                for (String word : wordsInLine) {
                    if (occurrences.containsKey(word)) {
                        occurrences.put(word, occurrences.get(word) + 1);
                    }
                }
            }
            occurrences.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).forEach(entry -> {
                String write = entry.getKey() + " - " + entry.getValue();
                out.println(write);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
