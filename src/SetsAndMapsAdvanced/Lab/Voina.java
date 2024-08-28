package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        firstPlayer.forEach(e -> System.out.print(e + " "));
        System.out.println();
        secondPlayer.forEach(e -> System.out.print(e + " "));

        int count = 1;
        while (count++ <= 50) {

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove((Integer) firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove((Integer)secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) break;

        }

        if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        }
        else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        }
        else {
            System.out.println("Draw!");
        }


    }
}
