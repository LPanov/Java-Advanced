package DefiningClasses.Exercises.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");

            String name = token[0];
            String choice = token[1];
            Person person;
            if (people.containsKey(name)) {
                person = people.get(name);
            } else {
                person = new Person(name);
            }


            if (choice.equals("company")) {
                String companyName = token[2];
                String department = token[3];
                double salary = Double.parseDouble(token[4]);
                Company company = new Company(companyName, department, salary);
                person.setCompany(company);
            }
            else if (choice.equals("car")) {
                String model = token[2];
                int speed = Integer.parseInt(token[3]);
                Car car = new Car(model, speed);
                person.setCar(car);
            }
            else if (choice.equals("pokemon")) {
                String namePokemon = token[2];
                String pokemonType = token[3];
                person.getPokemons().add(new Pokemon(namePokemon, pokemonType));
            }
            else if (choice.equals("parents")) {
                String nameParent = token[2];
                String birthday = token[3];
                person.getParents().add(new Parent(nameParent, birthday));
            }
            else if (choice.equals("children")) {
                String nameChildren = token[2];
                String birthday = token[3];
                person.getChildren().add(new Child(nameChildren, birthday));
            }
            people.put(name, person);
            command = scanner.nextLine();
        }

        String personToShow = scanner.nextLine();
        System.out.println(people.get(personToShow).toString());
        System.out.println("Pokemon:");
        people.get(personToShow).getPokemons().forEach(System.out::println);
        System.out.println("Parents:");
        people.get(personToShow).getParents().forEach(System.out::println);
        System.out.println("Children:");
        people.get(personToShow).getChildren().forEach(System.out::println);
    }
}
