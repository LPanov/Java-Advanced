package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        String path = "src/StreamsFilesAndDirectories/Files-and-Streams";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName()+": [" + listOfFiles[i].length() + "]");
                }
            }
        }

    }
}
