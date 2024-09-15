package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] integers = scanner.nextLine().split(", ");
        Function<String, Integer> parse = a -> Integer.parseInt(a);

        List<Integer> nums = Arrays.stream(integers).map(parse).collect(Collectors.toList());

        AtomicInteger sum = new AtomicInteger();
        nums.forEach(n -> sum.addAndGet(n));
        System.out.println("Count = " + nums.size());
        System.out.println("Sum = " + sum);


    }
}
