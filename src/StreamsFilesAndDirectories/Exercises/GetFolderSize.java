package StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/Exercises Resources";

        File folder = new File(path);
        System.out.println("Folder size: " + folderSize(folder));
    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
