package Generics.Exercises.GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Box<Integer> box = new Box<>(list);
        box.swap(indexes[0], indexes[1]);
        System.out.println(box);
    }
}
