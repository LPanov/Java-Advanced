package SetsAndMapsAdvanced.Exercises;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.Entry.comparingByValue;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Long>> venues = new LinkedHashMap<>();
        String regex = "(?<singer>.+)\\s+@(?<place>.+)\\s+(?<price>\\d+)\\s+(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String command = sc.nextLine();
        while (!command.equals("End")) {
            Matcher matcher = pattern.matcher(command);
            String singer = "";
            String place = "";
            long total = 0;
            while (matcher.find()) {
                singer = matcher.group("singer");
                place = matcher.group("place");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                total = (long) price * count;
            }
            if (!place.isEmpty()) {
                if (!venues.containsKey(place)) {
                    venues.put(place, new LinkedHashMap<>());
                    venues.get(place).put(singer, total);
                } else {
                    if (!venues.get(place).containsKey(singer)) {
                        venues.get(place).put(singer, total);
                    } else {
                        venues.get(place).put(singer, venues.get(place).get(singer) + total);

                    }
            }
            }
            command = sc.nextLine();
        }

        venues.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted(Collections.reverseOrder(comparingByValue()))
                    .forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));
        });
    }
}
