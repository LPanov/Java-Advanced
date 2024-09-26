package Generics.Exercises.CountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        String compare = scanner.nextLine();
        Box<String> box = new Box<>(list);
        System.out.println(box.countGreater(compare));
    }
}
