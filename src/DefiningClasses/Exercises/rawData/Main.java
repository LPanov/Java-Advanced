package DefiningClasses.Exercises.rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(type, weight);
            Tire tire1 = new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6]));
            Tire tire2 = new Tire(Double.parseDouble(input[7]), Integer.parseInt(input[8]));
            Tire tire3 = new Tire(Double.parseDouble(input[9]), Integer.parseInt(input[10]));
            Tire tire4 = new Tire(Double.parseDouble(input[11]), Integer.parseInt(input[12]));

            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }

        String command = sc.nextLine();
        Predicate<Tire> lowPressure = a -> a.getPressure() < 1;

        if (command.equals("fragile")) {
            cars.stream()
                    .filter(f -> f.getCargo().getType().equals("fragile"))
                    .filter(f -> lowPressure.test(f.getTire1())||
                                f.getTire2().getPressure() < 1 ||
                                f.getTire3().getPressure() < 1 ||
                                f.getTire4().getPressure() < 1)
                    .forEach(car -> System.out.println(car.getModel()));
        }
        else if (command.equals("flamable")) {
            cars.stream()
                    .filter(f -> f.getCargo().getType().equals("flamable"))
                    .filter(f -> f.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }

}
