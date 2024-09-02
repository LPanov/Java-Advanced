package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sets = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = sets[0];
        int m = sets[1];

        Set<Integer> N = new LinkedHashSet<>();
        Set<Integer> M = new LinkedHashSet<>();
        Set<Integer> repeated = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(sc.nextLine());
            N.add(numbers);
        }
        for (int i = 0; i < m; i++) {
            int numbers = Integer.parseInt(sc.nextLine());
            M.add(numbers);
        }

        for (int k : N) {
            if (M.contains(k)) repeated.add(k);
        }

        repeated.forEach(e -> System.out.print(e + " "));
    }
}
