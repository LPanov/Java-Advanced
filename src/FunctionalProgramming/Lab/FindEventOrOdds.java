package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEventOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        Predicate<Integer> even = a -> a % 2 == 0;
        Predicate<Integer> odd = a -> a % 2 != 0;

        Function<String, Boolean> checkEven = s -> s.equals("even");

        List<Integer> nums = IntStream.range(range[0], range[1] + 1).boxed().collect(Collectors.toList());
        if (checkEven.apply(command)) nums.stream().filter(even::test).forEach(f -> System.out.print(f + " "));
        else nums.stream().filter(odd::test).forEach(f -> System.out.print(f + " "));
    }
}
