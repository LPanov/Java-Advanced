package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> input = Arrays.stream(sc.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        input.forEach(d -> {
            if (occurrences.containsKey(d)) {
                occurrences.put(d, occurrences.get(d) + 1);
            } else {
                occurrences.put(d, 1);
            }
        });

        occurrences.entrySet().stream().forEach(e -> System.out.println(String.format("%.1f", e.getKey()) + " -> " + e.getValue()));
    }
}
