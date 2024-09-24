package DefiningClasses.Exercises.speedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split("\\s+");
            String model = strings[0];
            double fuelAmount = Double.parseDouble(strings[1]);
            double cost1KM = Double.parseDouble(strings[2]);

            Car car = new Car(model, fuelAmount, cost1KM);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            String model = token[1];
            double distanceTraveled = Double.parseDouble(token[2]);
            if (cars.containsKey(model)) {
                if (cars.get(model).canMove(distanceTraveled)) {
                    double fuelAmount = cars.get(model).getFuelAmount();
                    double costOneKM = cars.get(model).getCostOneKM();
                    cars.get(model).setFuelAmount(fuelAmount - distanceTraveled*costOneKM);
                    double distanceCar = cars.get(model).getDistanceTraveled();
                    cars.get(model).setDistanceTraveled(distanceCar + distanceTraveled);

                } else System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }

        cars.entrySet().stream().forEach(car -> System.out.printf("%s %.2f %.0f%n", car.getValue().getModel(), car.getValue().getFuelAmount(), car.getValue().getDistanceTraveled()));
    }
}
