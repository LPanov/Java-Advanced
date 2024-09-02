package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compound = sc.nextLine().split(" ");
            elements.addAll(Arrays.asList(compound));
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
