package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = new Function<List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers) {
                List<Integer> incremented = new ArrayList<>();
                integers.forEach(f -> incremented.add(++f));
                return incremented;
            }
        };
        Function<List<Integer>, List<Integer>> subtract = integers -> {
            List<Integer> incremented = new ArrayList<>();
            integers.forEach(f -> incremented.add(--f));
            return incremented;
        };
        Function<List<Integer>, List<Integer>> multiply = integers -> {
            List<Integer> incremented = new ArrayList<>();
            integers.forEach(f -> incremented.add(f * 2));
            return incremented;
        };

        String s = scanner.nextLine();
        while (!s.equals("end")) {

            if (s.equals("add")) nums = add.apply(nums);
            else if (s.equals("subtract")) nums = subtract.apply(nums);
            else if (s.equals("multiply")) nums = multiply.apply(nums);
            else if (s.equals("print")) {
                nums.forEach(f -> System.out.print(f + " "));
                System.out.println();
            }
            s = scanner.nextLine();
        }

        //nums.forEach(f -> System.out.print(f + " "));

    }
}
