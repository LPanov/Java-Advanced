package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallest = integers ->  {
            int index = 0;
            int min = integers.get(0);
            for (int i = 1; i < integers.size(); i++) {
                if (integers.get(i) <= min) {
                    min = integers.get(i);
                    index = i;
                }
            }
            return index;
        };

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(findSmallest.apply(nums));
    }
}
