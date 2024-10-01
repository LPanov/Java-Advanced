package IteratorsAndComparators.Exercises.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.add(new Person(name, age));
        }

        TreeSet<Person> firstSet = new TreeSet<>(new NameComparator());
        firstSet.addAll(people);
        firstSet.forEach(System.out::println);
        TreeSet<Person> secondSet = new TreeSet<>(new AgeComparator());
        secondSet.addAll(people);
        secondSet.forEach(System.out::println);
    }
}
