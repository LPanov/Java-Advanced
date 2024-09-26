package Generics.Exercises.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split("\\s+");
        String name1 = input1[0] + " " + input1[1];
        String address = input1[2];
        String town = input1[3];
        Threeuple<String, String, String> nameAddress = new Threeuple<>(name1, address, town);

        String[] input2 = scanner.nextLine().split("\\s+");
        String name2 = input2[0];
        int liters = Integer.parseInt(input2[1]);
        Boolean isDrunk = input2[2].equals("drunk");
        Threeuple<String, Integer, Boolean> nameLiters = new Threeuple<>(name2, liters, isDrunk);

        String[] input3 = scanner.nextLine().split("\\s+");
        String name3 = input3[0];
        double d = Double.parseDouble(input3[1]);
        String bankName = input3[2];
        Threeuple<String, Double, String> nameBalance = new Threeuple<>(name3, d, bankName);

        System.out.println(nameAddress);
        System.out.println(nameLiters);
        System.out.println(nameBalance);

    }
}
