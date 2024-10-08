package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkLength = s -> s.length() <= n;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkLength).forEach(System.out::println);
    }
}
