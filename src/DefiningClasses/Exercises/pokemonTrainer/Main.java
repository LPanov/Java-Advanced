package DefiningClasses.Exercises.pokemonTrainer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap();

        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] input = command.split("\\s+");
            String nameTrainer = input[0];
            String namePokemon = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);

            Pokemon pokemon = new Pokemon(namePokemon, element, health);
            if (trainers.containsKey(nameTrainer)) {
                trainers
                        .get(nameTrainer)
                        .getPokemons().add(pokemon);
            }
            else {
                trainers.put(nameTrainer, new Trainer(nameTrainer));
                trainers
                        .get(nameTrainer)
                        .getPokemons().add(pokemon);
            }

            command = scanner.nextLine();
        }

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            String finalElement = element;
            trainers.entrySet().stream().forEach(trainer -> {
                AtomicInteger count = new AtomicInteger();
                trainer.getValue().getPokemons()
                        .stream().filter(p -> p.getElement().equals(finalElement))
                        .forEach(pokemon -> count.addAndGet(1));
                if (count.get() > 0) trainer.getValue().setNumberOfBadges(trainer.getValue().getNumberOfBadges() + count.get());
                else {
                    trainer.getValue().getPokemons().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    trainer.getValue().setPokemons(trainer.getValue().getPokemons()
                            .stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList()));
                }
            });

            element = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((t1, t2) -> t2.getValue().getNumberOfBadges() - t1.getValue().getNumberOfBadges())
                .forEach(trainer -> System.out.println(trainer.getValue()));

    }
}
