package IteratorsAndComparators.Exercises.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String command = reader.readLine();
        while (!command.equals("END")) {
            String[] token = command.split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            String town = token[2];
            people.add(new Person(name, age, town));

            command = reader.readLine();
        }

        int n = Integer.parseInt(reader.readLine());
        if (n < people.size()) {
            Person person = people.get(n);
            AtomicInteger equal = new AtomicInteger();
            AtomicInteger notEqual = new AtomicInteger();

            people.forEach(p -> {
                if (p.compareTo(person) == 0) equal.getAndIncrement();
                else notEqual.getAndIncrement();
            });

            if (equal.get() == 1) {
                System.out.println("No matches");
            }
            else System.out.println(equal + " " + notEqual + " " + people.size());
        }
        else System.out.println("No matches");


    }
}
