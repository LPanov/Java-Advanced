package DefiningClasses.Exercises.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nE = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < nE; i++) {
            String[] s = sc.nextLine().split(" ");
            if (s.length == 4) {
                Engine engine = new Engine(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]);
                engines.add(engine);
            }
            else if (s.length == 2) {
                Engine engine = new Engine(s[0], Integer.parseInt(s[1]));
                engines.add(engine);
            }
            else if (s.length == 3) {
                if (s[2].matches("\\d+")) {
                    Engine engine = new Engine(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    engines.add(engine);
                }
                else {
                    Engine engine = new Engine(s[0], Integer.parseInt(s[1]), s[2]);
                    engines.add(engine);
                }
            }
        }
//        for (Engine engine:engines) {
//            System.out.println(engine);
//        }

        int nC = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < nC; i++) {
            String[] s = sc.nextLine().split(" ");
            Engine eng = Car.getEngine(s[1], engines);
            if (s.length == 4) {
                Car car = new Car(s[0], eng, Integer.parseInt(s[2]), s[3]);
                cars.add(car);
            }
            else if (s.length == 2) {
                Car car = new Car(s[0], eng);
                cars.add(car);
            }
            else if (s.length == 3) {
                if (s[2].matches("\\d+")) {
                    Car car = new Car(s[0], eng, Integer.parseInt(s[2]));
                    cars.add(car);
                } else {
                    Car car = new Car(s[0], eng, s[2]);
                    cars.add(car);
                }
            }
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
