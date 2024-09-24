package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> sortEven = a -> a % 2 == 0;
        Predicate<Integer> sortOdd = a -> a % 2 != 0;

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = ((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (b % 2 == 0 && a % 2 != 0) {
                return 1;
            }
            return a.compareTo(b);
        });
        nums.sort(comparator);
        nums.forEach(n -> System.out.print(n + " "));

    }
}
