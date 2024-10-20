package RegularExam;

import java.util.*;
import java.util.stream.Collectors;

public class BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> strength = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        Deque<Integer> accuracy = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        int goals = 0;

        while (true) {
            if (strength.isEmpty()) break;
            if (accuracy.isEmpty()) break;

            int streng = strength.getLast();
            int acc = accuracy.getFirst();

            if (streng + acc == 100) {
                goals++;
                strength.removeLast();
                accuracy.removeFirst();
            }
            else if (streng + acc < 100) {
                if (streng < acc) {
                    strength.removeLast();
                }
                else if (acc < streng) {
                    accuracy.removeFirst();
                }
                else {
                    strength.removeLast();
                    strength.addLast(streng + acc);
                    accuracy.removeFirst();
                }
            }
            else if (streng + acc > 100){
                streng -= 10;
                strength.removeLast();
                strength.addLast(streng);
                accuracy.removeFirst();
                accuracy.addLast(acc);
            }
        }

        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
        }
        else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");
        }
        else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
        }
        else if (goals > 0 && goals < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goals > 0) System.out.println("Goals scored: " + goals);

        StringJoiner joiner = new StringJoiner(", ");
        if (!strength.isEmpty() && strength.getFirst() != 0) {
            strength.forEach(str -> joiner.add(str.toString()));
            System.out.println("Strength values left: " + joiner);
        }
        else if (!accuracy.isEmpty() && accuracy.getFirst() != 0) {
            accuracy.forEach(str -> joiner.add(str.toString()));
            System.out.println("Accuracy values left: " + joiner);
        }

        System.out.println(Arrays.deepToString(new int[3][3]).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", "").replace(", ", ""));


    }
}
