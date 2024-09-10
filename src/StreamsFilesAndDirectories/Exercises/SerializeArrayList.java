package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/29264.jpg";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/list.ser";

        List<Double> list = new ArrayList<>();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath))) {
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
