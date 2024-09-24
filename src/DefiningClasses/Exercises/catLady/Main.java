package DefiningClasses.Exercises.catLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Breed> cats = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            String breed = token[0];
            String name = token[1];
            double value = Double.parseDouble(token[2]);

            if (breed.equals("Siamese")) {
                Breed siamese = new Siamese(name, value);
                cats.put(name, siamese);
            }
            else if (breed.equals("Cymric")) {
                Breed cymric = new Cymric(name, value);
                cats.put(name, cymric);
            }
            else if (breed.equals("StreetExtraordinaire")) {
                Breed strayCat = new StreetExtraordinaire(name, value);
                cats.put(name, strayCat);
            }
            command = scanner.nextLine();
        }

        System.out.println(cats.get(scanner.nextLine()));
    }
}
