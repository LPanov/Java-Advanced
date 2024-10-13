package ExamPreparation.Retake10April2024;

import java.util.*;
import java.util.stream.Collectors;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> contestants = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        Deque<Integer> pies = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        int count = 0;

        while (true) {
            if (contestants.isEmpty()) break;
            if (pies.isEmpty()) break;

            int amount = contestants.getFirst();
            int pieces = pies.getLast();

            if (amount >= pieces) {
                amount -= pieces;

                if (amount == 0) {
                    contestants.removeFirst();
                }
                else {
                    contestants.removeFirst();
                    contestants.addLast(amount);
                }
                pies.removeLast();
            }
            else {
                int piecesLeft = pieces - amount;
                contestants.removeFirst();
                if (piecesLeft == 1) {
                    pies.removeLast();
                    if (!pies.isEmpty()) {
                        int add = pies.removeLast() + 1;
                        pies.addLast(add);
                    }
                    else pies.add(1);
                } else {
                    pies.removeLast();
                    pies.addLast(piecesLeft);
                }

            }

            /*contestants.forEach(c -> System.out.print(c + " "));
            System.out.println();
            pies.forEach(p -> System.out.print(p+" "));
            System.out.println();*/

        }



        if (!pies.isEmpty() && contestants.isEmpty()) {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            Iterator<Integer> iterator = pies.iterator();

            if (iterator.hasNext()) {
                System.out.print(iterator.next());
                while (iterator.hasNext()) System.out.print(", "+iterator.next());
            }
        }
        else if (!contestants.isEmpty() && pies.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            Iterator<Integer> iterator = contestants.iterator();

            if (iterator.hasNext()) {
                System.out.print(iterator.next());
                while (iterator.hasNext()) System.out.print(", "+iterator.next());
            }
        }
        else if (pies.isEmpty() && contestants.isEmpty()) {
            System.out.println("We have a champion!");
        }
    }
}
