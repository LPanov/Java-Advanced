package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Map<Character, Integer> occurrences = new TreeMap<>();

        for (char c : text.toCharArray()) {
            if (!occurrences.containsKey(c)) {
                occurrences.put(c, 1);
            } else {
                occurrences.put(c, occurrences.get(c) + 1);
            }
        }

        occurrences.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
