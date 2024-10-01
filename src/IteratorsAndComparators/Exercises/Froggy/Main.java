package IteratorsAndComparators.Exercises.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake lake = new Lake();

        String command = reader.readLine();
        while (!command.equals("END")) {
            List<Integer> integers = Arrays.stream(command.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
            lake.addAll(integers);
            lake.jumpOver();
            command = reader.readLine();
        }

        while (lake.getFrog().hasNext()) {
            System.out.print(lake.getFrog().next() + ", ");
        }
        System.out.print(lake.getFrog().getJumpedNumbers().getLast());


    }
}
