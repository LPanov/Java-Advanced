package Generics.Exercises.CountMethodDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(scanner.nextLine()));
        }

        Double compare = Double.parseDouble(scanner.nextLine());
        Box<Double> box = new Box<>(list);
        System.out.println(box.countGreater(compare));
    }
}
