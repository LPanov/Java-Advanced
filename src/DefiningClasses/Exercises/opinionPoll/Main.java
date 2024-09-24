package DefiningClasses.Exercises.opinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            people.add(new Person(input[0], Integer.parseInt(input[1])));
        }

        people.stream().filter(a -> a.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}
