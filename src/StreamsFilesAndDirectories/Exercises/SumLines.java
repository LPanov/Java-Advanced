package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            String line;
            while (reader.ready()) {
                int sum = 0;
                line = reader.readLine();
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
