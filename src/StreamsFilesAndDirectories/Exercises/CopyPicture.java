package StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/29264.jpg";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/picture-copy.jpg";

        try (FileInputStream fileInputStream = new FileInputStream(path);
             FileOutputStream fileOutputStream = new FileOutputStream(outPath)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
