package IteratorsAndComparators.Exercises.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedListTraversal<Integer> linkedListTraversal = new LinkedListTraversal<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("Add")) {
                linkedListTraversal.add(Integer.parseInt(command[1]));
            }
            else if (command[0].equals("Remove")) {
                linkedListTraversal.remove(Integer.parseInt(command[1]));
            }
        }

        System.out.println(linkedListTraversal.getSize());
        linkedListTraversal.forEach(f -> System.out.print(f + " "));
    }
}
