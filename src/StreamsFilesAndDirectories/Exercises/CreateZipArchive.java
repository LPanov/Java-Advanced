package StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String path1 = "src/StreamsFilesAndDirectories/Exercises Resources/input.txt";
        String path2 = "src/StreamsFilesAndDirectories/Exercises Resources/inputOne.txt";
        String path3 = "src/StreamsFilesAndDirectories/Exercises Resources/inputTwo.txt";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/files.zip";

        try (FileInputStream fis1 = new FileInputStream(path1);
             FileInputStream fis2 = new FileInputStream(path2);
             FileInputStream fis3 = new FileInputStream(path3);
             ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(outPath))) {

            ZipEntry zipEntry = new ZipEntry(path1);
            zipOut.putNextEntry(zipEntry);
            zipEntry = new ZipEntry(path2);
            zipOut.putNextEntry(zipEntry);
            zipEntry = new ZipEntry(path3);
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis1.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            while ((length = fis2.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            while ((length = fis3.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis1.close();
            fis2.close();
            fis3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
