package Generics.Exercises.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i =0; i < n; i++) {
            Box<String> box = new Box<String>(scanner.nextLine());
            String str = box.toString().getClass() + box.toString();
            System.out.println(str.substring(6));
        }

    }
}
