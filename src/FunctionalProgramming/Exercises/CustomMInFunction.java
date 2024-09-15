package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMInFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallest = integers ->  {
        int min = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) < min) {
                min = integers.get(i);
            }
        }
        return min;
        };

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(findSmallest.apply(nums));
    }

}
