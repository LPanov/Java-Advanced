package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Set<String> strings = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            strings.add(str);
        }

        strings.forEach(System.out::println);
    }
}
