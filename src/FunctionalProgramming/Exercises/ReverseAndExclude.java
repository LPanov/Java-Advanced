package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isNotDivisible = a -> a % n != 0;
        Consumer<List<Integer>> reverse = Collections::reverse;
        reverse.accept(nums);
        nums.stream().filter(isNotDivisible).forEach(f -> System.out.print(f + " "));
    }
}
