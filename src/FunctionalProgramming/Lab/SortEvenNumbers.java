package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        nums.removeIf(num -> num % 2 != 0);
        List<String> stringNums = nums.stream().map(i -> i.toString()).collect(Collectors.toList());
        System.out.println(String.join(", ", stringNums));
        nums.sort(Integer::compareTo);
        stringNums = nums.stream().map(i -> i.toString()).collect(Collectors.toList());
        System.out.println(String.join(", ", stringNums));
    }
}
