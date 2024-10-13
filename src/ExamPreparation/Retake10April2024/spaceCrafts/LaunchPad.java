package ExamPreparation.Retake10April2024.spaceCrafts;

//package spaceCrafts;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new LinkedList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (spacecrafts.size() < capacity) {
            if (spacecrafts.stream().noneMatch(s -> s.getName().equals(spacecraft.getName()))) {
                spacecrafts.add(spacecraft);
            } else {
                throw new RuntimeException("This spacecraft already exists!");
            }
        }
        else System.out.println("This launchpad is at full capacity!");
    }

    public boolean removeSpacecraft (String name) {
        Spacecraft spacecraft = this.getSpacecraft(name);
        spacecrafts.remove(spacecraft);
        return spacecraft != null;
    }

    public String getHeaviestSpacecraft() {
        int heaviest = 0;
        String name = "";
        for (Spacecraft spacecraft : spacecrafts) {
            if (heaviest < spacecraft.getWeight()) {
                heaviest = spacecraft.getWeight();
                name = spacecraft.getName();
            }
        }

        return name + " - " + heaviest + "kg.";
    }

    public Spacecraft getSpacecraft(String name) {
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)){
                return spacecraft;
            }
        }

        return null;
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> filter = new LinkedList<>();
        for (Spacecraft spacecraft : spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                filter.add(spacecraft);
            }
        }

        if (filter.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }

        return filter;
    }

    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        str.append("Spacecrafts launched from").append(this.name).append(":\n");
        if (spacecrafts.isEmpty()) {
            str.append("none");
        }
        else {
            AtomicInteger count = new AtomicInteger(1);
            spacecrafts.forEach(sp -> {
                str.append(count.get()).append(". ").append(sp.getName()).append("\n");
                count.getAndIncrement();
            });
        }

        return str.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }
}
