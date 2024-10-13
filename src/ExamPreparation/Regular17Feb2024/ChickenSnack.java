package ExamPreparation.Regular17Feb2024;

import java.util.*;
import java.util.stream.Collectors;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> money = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        Deque<Integer> prices = new ArrayDeque<>
                (Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        int count = 0;

        while (true) {
            if (money.isEmpty()) break;
            if (prices.isEmpty()) break;

            int amount = money.getLast();
            int price = prices.getFirst();

            if (amount == price) {
                money.removeLast();
                prices.removeFirst();
                count++;
            }
            else if (amount > price) {
                int change = amount - price;
                money.removeLast();

                if (!money.isEmpty()) {
                    int last =  money.removeLast() + change;
                    money.addLast(last);
                }

                prices.removeFirst();
                count++;
            }
            else {
                money.removeLast();
                prices.removeFirst();
            }
        }

        if (count == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
        else if (count >= 4) {
            System.out.println("Gluttony of the day! Henry ate "+count+" foods.");
        }
        else if (count == 1) {
            System.out.println("Henry ate: "+count+" food.");
        }
        else {
            System.out.println("Henry ate: "+count+" foods.");
        }
    }
}
