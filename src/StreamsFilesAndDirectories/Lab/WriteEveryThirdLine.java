package StreamsFilesAndDirectories.Lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectories/input.txt";
        String pathOut = "src/StreamsFilesAndDirectories/05.WriteEveryThirdLineOutput.txt";

        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(path)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(pathOut))
        ) {
            String line;
            int lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber % 3 == 0) {
                    out.println(line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
