package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;

public class NestedFolders {
    public static void main(String[] args) throws IOException{
        String path = "src/StreamsFilesAndDirectories/Files-and-Streams";
        File dir = new File(path);

        Deque<File> files = new ArrayDeque<>();
        files.addLast(dir);
        List<String> folders = new ArrayList<>();

        while (! files.isEmpty()) {
            File currentDir = files.removeFirst();
            if (currentDir.isDirectory()) {
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    if (file.isDirectory()) {
                        files.addLast(file);
                    }
                }
                folders.add(currentDir.getName());
            }
        }
        folders.forEach(System.out::println);
        System.out.println(String.format("%d folders", folders.size()));

    }

}
