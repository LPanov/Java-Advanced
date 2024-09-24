package DefiningClasses.Lab.carInfo;

import java.util.Scanner;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.horsepower = -1;
    }
    public Car(String brand, int horsepower) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = horsepower;
    }
    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String carInfo() {
        return "The car is: "+getBrand()+" "+getModel()+" - "+getHorsepower()+" HP.";
    }
}
