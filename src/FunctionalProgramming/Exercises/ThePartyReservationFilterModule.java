package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String[] token = command.split(";");
            String parameter = token[2];

            Predicate<String> predicate = null;
            if (token[1].contains("Starts")) predicate = str -> !str.startsWith(parameter);
            else if (token[1].contains("Ends")) predicate = str -> !str.endsWith(parameter);
            else if (token[1].contains("Contains")) predicate = str -> !str.contains(parameter);
            else if (token[1].contains("Length")) predicate = str -> str.length() != Integer.parseInt(parameter);

            Predicate<String> add = str -> str.contains("Add");

            if (add.test(token[0])) {
                predicates.putIfAbsent(parameter, predicate);
            } else {
               if (predicates.containsKey(parameter)) predicates.remove(parameter);
            }
            //guests.stream().filter(combineFilters(predicates)).forEach(guest -> System.out.print(guest + " "));

            command = scanner.nextLine();
        }

        guests.stream().filter(combineFilters(predicates)).forEach(guest -> System.out.print(guest + " "));
    }

    public static Predicate<String> combineFilters(Map<String, Predicate<String>> filters) {
        List<Predicate<String>> temp = new ArrayList<>(filters.values());
        return temp.stream().reduce(Predicate::and).orElse(x -> true);
    }
}
