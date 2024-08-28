package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, List<String>>> locations = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!locations.containsKey(continent)) {
                locations.put(continent, new LinkedHashMap<>());
                locations.get(continent).put(country, new ArrayList<>());
                locations.get(continent).get(country).add(city);
            } else {
                if (!locations.get(continent).containsKey(country)) {
                    locations.get(continent).put(country, new ArrayList<>());
                    locations.get(continent).get(country).add(city);
                } else {
                    locations.get(continent).get(country).add(city);
                }

            }
        }

        locations.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey()+":");
            entry.getValue().entrySet().stream().forEach(e -> {
                System.out.print("\t" + e.getKey() + " -> ");
                System.out.println(String.join(", ", e.getValue()));
            });
        });
    }
}
