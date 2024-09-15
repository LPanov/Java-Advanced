package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Predicate<Integer>> predicates = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> range = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());

        List<Integer> divisibles = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < divisibles.size(); i++) {
            int finalI = i;
            Predicate<Integer> predicate = a -> a % divisibles.get(finalI) == 0;
            predicates.add(predicate);
        }

        range.stream().filter(combineFilters(predicates)).forEach(number -> System.out.print(number + " "));
    }

    public static Predicate<Integer> combineFilters(List<Predicate<Integer>> filters) {
        return filters.stream().reduce(Predicate::and).orElse(x -> true);
    }
}
