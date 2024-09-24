package DefiningClasses.Exercises.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }
    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }
    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public static boolean existEngine(String model, List<Engine> engines) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) return true;
        }
        return  false;
    }
    public static Engine getEngine (String model, List<Engine> engines) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) return engine;
        }
        return null;

    }

    @Override
    public String toString() {
        if (weight > 0) {
            if (engine.getDisplacement() > 0) {
                return model + ":\n" +
                        "  " + engine.getModel() + ":\n" +
                        "    " + "Power: " + engine.getPower() + "\n" +
                        "    " + "Displacement: " + engine.getDisplacement() + "\n" +
                        "    " + "Efficiency: " + engine.getEfficiency() + "\n" +
                        "  Weight: " + weight + "\n" +
                        "  Color: " + color;
            } else {
                return model + ":\n" +
                        "  " + engine.getModel() + ":\n" +
                        "    " + "Power: " + engine.getPower() + "\n" +
                        "    " + "Displacement: " + "n/a" + "\n" +
                        "    " + "Efficiency: " + engine.getEfficiency() + "\n" +
                        "  Weight: " + weight + "\n" +
                        "  Color: " + color;
            }

        } else {
            if (engine.getDisplacement() > 0) {
                return model + ":\n" +
                        "  " + engine.getModel() + ":\n" +
                        "    " + "Power: " + engine.getPower() + "\n" +
                        "    " + "Displacement: " + engine.getDisplacement() + "\n" +
                        "    " + "Efficiency: " + engine.getEfficiency() + "\n" +
                        "  Weight: " + "n/a" + "\n" +
                        "  Color: " + color;
            } else {
                return model + ":\n" +
                        "  " + engine.getModel() + ":\n" +
                        "    " + "Power: " + engine.getPower() + "\n" +
                        "    " + "Displacement: " + "n/a" + "\n" +
                        "    " + "Efficiency: " + engine.getEfficiency() + "\n" +
                        "  Weight: " + "n/a" + "\n" +
                        "  Color: " + color;
            }
        }
    }
}

