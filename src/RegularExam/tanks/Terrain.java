//package tanks;
package RegularExam.tanks;

import java.util.*;
import java.util.stream.Collectors;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.tanks = new LinkedList<>();
        this.area = area;
    }

    public String addTank(Tank tank) {
       if (tanks.stream().anyMatch(t -> t.getBrand().equals(tank.getBrand()) && t.getModel().equals(tank.getModel()))) {
           return "Tank with this brand and model already exists!";
       }
       else {
           if (getType().equals("Swamp") && tank.getWeight() >= 14000) {
               return "This "+tank.getBrand()+" is too heavy for this terrain!";
           }
           else {
               this.tanks.add(tank);
               return "Tank "+tank.getBrand()+" "+tank.getModel()+" added.";
           }
       }
    }

    public boolean removeTank(String brand, String model) {
        Tank tank = this.getTankByBrandAndModel(brand, model);
        tanks.remove(tank);
        return tank != null;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> biggerTanks = this.tanks.stream().filter(t -> t.getBarrelCaliber() >= barrelCaliber).collect(Collectors.toList());
        StringBuilder str = new StringBuilder();
        if (biggerTanks.isEmpty()) {
            str.append("There are no tanks with the specified caliber.");
        }
        else {
            str.append("Tanks with caliber more than ").append(barrelCaliber).append("mm: ");
            StringJoiner joiner = new StringJoiner(", ");
            biggerTanks.forEach(bt -> joiner.add(bt.getBrand()));
            str.append(joiner);
        }
        return str.toString();
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        return tanks.stream()
                .filter(f -> f.getBrand().equals(brand))
                .filter(f -> f.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public String getTheMostArmoredTank() {
        Tank mostArmoredTank = tanks.stream().max(Comparator.comparing(Tank::getArmor)).orElse(null);
        assert mostArmoredTank != null;
        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                    mostArmoredTank.getBrand(), mostArmoredTank.getModel(), mostArmoredTank.getArmor());
    }

    public int getCount() {
        return tanks.size();
    }

    public String getType() {
        return type;
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public int getArea() {
        return area;
    }

    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        if (tanks.isEmpty()) {
            str.append("There are no tanks in the ").append(this.type.toLowerCase()).append(".");
        }
        else {
            str.append("Tanks located in the ").append(this.type.toLowerCase()).append(":\n");
            tanks.forEach(tank -> str.append("-- ")
                    .append(tank.getBrand()).append(" ")
                    .append(tank.getModel()).append("\n"));
        }
        return str.toString();
    }
}
