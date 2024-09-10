package StreamsFilesAndDirectories.Exercises;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializeCustomObject {
    public static class Course  implements Serializable {
        public String name;
        public int count;
    }
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/Exercises Resources/29264.jpg";
        String outPath = "src/StreamsFilesAndDirectories/Exercises Resources/course.ser";

        Course course = new Course();
        course.name = "Course1";
        course.count = 10;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath))) {
            oos.writeObject(course);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
