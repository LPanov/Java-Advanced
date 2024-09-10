package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/input.txt";
        String pathOut = "src/StreamsFilesAndDirectories/02.WriteToFileOutput.txt";
        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        try (FileInputStream filestream = new FileInputStream(path)){
            int oneByte = filestream.read();
            FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = filestream.read();
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }

    }
}
