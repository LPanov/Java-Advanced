package FunctionalProgramming.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Predicate<String> isUpper = a -> Character.isUpperCase(a.charAt(0));

        List<String> startWithUpperCase = Arrays.stream(input).filter(isUpper).collect(Collectors.toList());

        System.out.println(startWithUpperCase.size());
        startWithUpperCase.forEach(System.out::println);

    }
}
