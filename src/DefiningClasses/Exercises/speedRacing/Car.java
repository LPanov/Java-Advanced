package DefiningClasses.Exercises.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double costOneKM;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double costOneKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costOneKM = costOneKM;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getCostOneKM() {
        return costOneKM;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean canMove(double distance) {
        return costOneKM * distance <= fuelAmount;
    }

}
