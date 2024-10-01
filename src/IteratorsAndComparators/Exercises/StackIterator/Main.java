package IteratorsAndComparators.Exercises.StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (command.contains("Push")) {
                List<Integer> integers = Arrays.stream(command.substring(5).split(", "))
                        .map(Integer::parseInt).collect(Collectors.toList());
                integers.forEach(stack::push);
            }
            else if (command.equals("Pop")) {
                if (stack.getList().isEmpty()) {
                    System.out.println("No elements");
                } else stack.pop();
            }
            command = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);

    }
}

