package FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> pairs = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            pairs.put(name, age);
        }
        String condition = scanner.nextLine();
        int ageRestriction = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiFunction<String, Integer, Boolean> biFunction = new BiFunction<String, Integer, Boolean>() {
            @Override
            public Boolean apply(String s, Integer integer) {
                if (s.equals("older")) {
                    return integer >= ageRestriction;
                }
                else if (s.equals("younger")) {
                    return integer <= ageRestriction;
                }
                return false;
            }
        };
        BiFunction<String, Map.Entry<String, Integer>, String> formatPrint = new BiFunction<String, Map.Entry<String, Integer>, String>() {
            @Override
            public String apply(String s, Map.Entry<String, Integer> integer) {
                if (s.equals("name age")) {
                    return integer.getKey() + " - " + integer.getValue();
                }
                else if (s.equals("name")) {
                    return integer.getKey();
                }
                else if (s.equals("age")) {
                    return String.valueOf(integer.getValue());
                }
                else return null;
            }
        };

        pairs.entrySet().stream()
                .filter(f -> biFunction.apply(condition, f.getValue()))
                .forEach(entry -> System.out.println(formatPrint.apply(format, entry)));
    }

}

