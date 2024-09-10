package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/input.txt";
        String pathOut = "src/StreamsFilesAndDirectories/03.CopyBytesOutput.txt";

        try (FileInputStream filestream = new FileInputStream(path)){
            int oneByte = filestream.read();
            FileOutputStream fileOutputStream = new FileOutputStream(pathOut);
            while (oneByte >= 0) {
                String digits = String.valueOf(oneByte);
                if (!digits.equals("32") && !digits.equals("10")) {
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                } else {
                    fileOutputStream.write(oneByte);
                }
                oneByte = filestream.read();
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
