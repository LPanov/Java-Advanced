package DefiningClasses.Exercises.carSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }
    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public String getModel() {
        return model;
    }

    public int getPower() {return power; }

    public int getDisplacement() {return displacement; }

    public String getEfficiency() { return efficiency;}

    @Override
    public String toString() {
        if (displacement == 0) {
            return model + ":\n" +
                    "\tPower: " + power + '\n' +
                    "\tDisplacement: " + "n/a" + '\n' +
                    "\tEfficiency: " + efficiency + '\n';
        }
        else {
            return model + ":\n" +
                    "  Power: " + power + '\n' +
                    "  Displacement: " + displacement + '\n' +
                    "  Efficiency: " + efficiency;
        }

    }
}
