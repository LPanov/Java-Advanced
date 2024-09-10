package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;


public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/input.txt";
        String pathOut = "src/StreamsFilesAndDirectories/04.ExtractIntegersOutput.txt";

        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream(path));
            BufferedWriter out = new BufferedWriter(new FileWriter(pathOut));

            while (inputStream.hasNext()) {
                if (inputStream.hasNextInt()) {
                    int digit = inputStream.nextInt();
                    out.write(String.valueOf(digit));
                    out.write("\n");
                    System.out.println(digit);
                }
                inputStream.next();
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
