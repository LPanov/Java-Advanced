package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> removeStart = str -> {
            List<String> copy = guests.stream().filter(guest -> guest.startsWith(str)).collect(Collectors.toList());
            guests.removeAll(copy);
        };
        Consumer<String> removeEnd = str -> {
            List<String> copy = guests.stream().filter(guest -> guest.endsWith(str)).collect(Collectors.toList());
            guests.removeAll(copy);
        };
        Consumer<Integer> removeLength = num -> {
            List<String> copy = guests.stream().filter(guest -> guest.length() == num).collect(Collectors.toList());
            guests.removeAll(copy);
        };

        Consumer<String> doubleStart = str -> {
            List<String> copy = guests.stream().filter(guest -> guest.startsWith(str)).collect(Collectors.toList());
            guests.addAll(copy);
        };
        Consumer<String> doubleEnd = str -> {
            List<String> copy = guests.stream().filter(guest -> guest.endsWith(str)).collect(Collectors.toList());
            guests.addAll(copy);
        };
        Consumer<Integer> doubleLength = num -> {
            List<String> copy = guests.stream().filter(guest -> guest.length() == num).collect(Collectors.toList());
            guests.addAll(copy);
        };

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String[] token = command.split("\\s+");
            String str = token[2];

            if (token[0].equals("Remove")) {
                if (token[1].equals("StartsWith")) removeStart.accept(str);
                else if (token[1].equals("EndsWith")) removeEnd.accept(str);
                else if (token[1].equals("Length")) removeLength.accept(Integer.parseInt(str));
            }
            else if (token[0].equals("Double")) {
                if (token[1].equals("StartsWith")) doubleStart.accept(str);
                else if (token[1].equals("EndsWith")) doubleEnd.accept(str);
                else if (token[1].equals("Length")) doubleLength.accept(Integer.parseInt(str));
            }

            command = scanner.nextLine();
        }

        Collections.sort(guests);
        if (!guests.isEmpty()) System.out.println(String.join(", ", guests) + " are going to the party!");
        else System.out.println("Nobody is going to the party!");
    }
}
