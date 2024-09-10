package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/input.txt";

        try (FileInputStream filestream = new FileInputStream(path)){
            int oneByte = filestream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = filestream.read();
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
