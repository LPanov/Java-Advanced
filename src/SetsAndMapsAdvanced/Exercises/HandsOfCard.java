package SetsAndMapsAdvanced.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> hands = new LinkedHashMap<>();
        Map<String, Set<String>> handsVisual = new LinkedHashMap<>();

        String command = sc.nextLine();
        while (!command.equals("JOKER")) {
            String[] token = command.split(": ");
            String name = token[0];
            String[] hand = token[1].split(", ");

            if (!handsVisual.containsKey(name)) {
                handsVisual.put(name, new LinkedHashSet<>());
                for (String card : hand) {
                    handsVisual.get(name).add(card);
                }
            } else {
                for (String card : hand) {
                    handsVisual.get(name).add(card);
                }
            }

            command = sc.nextLine();
        }

        handsVisual.entrySet().stream().forEach(entry -> {
            int points = 0;
            for (String card : entry.getValue()) {
                int power = getPower(card);

                if (Character.isDigit(card.charAt(0))) {
                    if (card.length() == 2) points += Character.getNumericValue(card.charAt(0))*power;
                    else points += Integer.parseInt(card.substring(0, 2)) * power;
                } else {
                    if (card.charAt(0) == 'J') points += 11*power;
                    else if (card.charAt(0) == 'Q') points += 12*power;
                    else if (card.charAt(0) == 'K') points += 13*power;
                    else if (card.charAt(0) == 'A') points += 14*power;
                }

            }

            hands.put(entry.getKey(), points);
        });

        hands.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static int getPower(String card) {
        int power = 0;
        if (card.length() == 2) {
            if (card.charAt(1) == 'S') power = 4;
            else if (card.charAt(1) == 'H') power = 3;
            else if (card.charAt(1) == 'D') power = 2;
            else if (card.charAt(1) == 'C') power = 1;
        } else {
            if (card.charAt(2) == 'S') power = 4;
            else if (card.charAt(2) == 'H') power = 3;
            else if (card.charAt(2) == 'D') power = 2;
            else if (card.charAt(2) == 'C') power = 1;
        }
        return power;
    }
}
