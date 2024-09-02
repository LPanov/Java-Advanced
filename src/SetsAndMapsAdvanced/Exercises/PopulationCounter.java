package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> locations = new LinkedHashMap<>();

        String command = sc.nextLine();
        while (!command.equals("report")) {
            String[] input = command.split("\\|");
            String city = input[0];
            String country = input[1];
            long population = Integer.parseInt(input[2]);

            locations.putIfAbsent(country, new LinkedHashMap<>());
            locations.get(country).putIfAbsent(city, population);

            command = sc.nextLine();
        }

        locations.entrySet().stream().sorted((s1, s2) -> {
            long sum1 = s1.getValue().values().stream().mapToLong(d -> d).sum();
            long sum2 = s2.getValue().values().stream().mapToLong(d -> d).sum();
            return Long.compare(sum2, sum1);
        }).forEach(entry -> {
            long total = entry.getValue().values().stream().mapToLong(d -> d).sum();
            System.out.printf("%s (total population: %d)%n", entry.getKey(), total);
            entry.getValue().entrySet().stream()
                    .sorted((s1, s2) -> {
                        long sum1 = s1.getValue();
                        long sum2 = s2.getValue();
                        return Long.compare(sum2, sum1);
                    })
                    .forEach(e -> System.out.println("=>" + e.getKey() + ": " + e.getValue()));
        });


    }
}
