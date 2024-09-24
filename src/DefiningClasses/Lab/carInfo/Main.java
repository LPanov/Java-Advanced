package DefiningClasses.Lab.carInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = null;
            if (input.length == 3) car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            else if (input.length == 2) {
                if (Character.isDigit(input[1].charAt(0))) car = new Car(input[0], Integer.parseInt(input[1]));
                else car = new Car(input[0], input[1]);
            }
            else if (input.length == 1) car = new Car(input[0]);


            System.out.println(car.carInfo());
        }
    }
}
