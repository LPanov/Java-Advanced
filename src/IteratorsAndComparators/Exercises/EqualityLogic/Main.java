package IteratorsAndComparators.Exercises.EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

        TreeSet<Person> treeSet = new TreeSet<>(new CompareNameAge());
        treeSet.addAll(people);

        HashSet<Person> hashSet = new HashSet<>(people);

        System.out.println(treeSet.size() + "\n" + hashSet.size());
    }
}
