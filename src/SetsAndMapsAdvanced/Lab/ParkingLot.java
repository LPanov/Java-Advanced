package SetsAndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Set<String> carNumbers = new LinkedHashSet<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split(", ");
            String direction = command[0];
            String carNumber = command[1];

            if (direction.equals("IN")) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }

            input = sc.nextLine();
        }
        if (carNumbers.isEmpty()) System.out.println("Parking Lot is Empty");
        else carNumbers.stream().forEach(System.out::println);
    }
}
