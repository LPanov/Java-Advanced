package Generics.Exercises.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s+");
        String name1 = input1[0] + " " + input1[1];
        String address = input1[2];
        Tuple<String, String> nameAddress = new Tuple<>(name1, address);

        String[] input2 = scanner.nextLine().split("\\s+");
        String name2 = input2[0];
        int liters = Integer.parseInt(input2[1]);
        Tuple<String, Integer> nameLiters = new Tuple<>(name2, liters);

        String[] input3 = scanner.nextLine().split("\\s+");
        int integer = Integer.parseInt(input3[0]);
        double d = Double.parseDouble(input3[1]);
        Tuple<Integer, Double> integerDouble = new Tuple<>(integer, d);

        System.out.println(nameAddress);
        System.out.println(nameLiters);
        System.out.println(integerDouble);

    }
}
