package ExamPreparation.Retake12August2024.surfers;
//package surfers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Beach {
    private String name;
    private int surferBoardForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surferBoardForRent) {
        this.name = name;
        this.surferBoardForRent = surferBoardForRent;
        this.surfers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String addSurfer(Surfer surfer) {
        if (surfer.ownSurfBoard()) {
            surfers.add(surfer);
            return "Surfer "+surfer.getName()+" added.";
        }
        else {
            if (surfer.getMoney() >= 50) {
                if (this.surferBoardForRent > 0) {
                    surfer.setMoney(surfer.getMoney() - 50);
                    this.surferBoardForRent--;
                    surfers.add(surfer);
                    return "Surfer "+surfer.getName()+" added.";
                }
                else return "There are no free surfboards.";
            }
            else return surfer.getName() + " has not enough money to rent a surfboard.";
        }
    }

    public boolean removeSurfer(String name) {
        int index = -1;
        for (int i = 0; i < this.surfers.size(); i++) {
            if (this.surfers.get(i).getName().equals("name")) {
                index = i;
            }
        }
        if (index >= 0) {
            this.surfers.remove(index);
            return true;
        }
        return false;
    }

    public String getMostExperiencedSurfer() {
        if (this.surfers.isEmpty()) {
            return "There are no surfers.";
        }
        else {
            int mostEXP = surfers.stream().map(Surfer::getExperience).max((a, b) -> a - b).get();
            String name = surfers.stream().filter(a -> a.getExperience() == mostEXP).collect(Collectors.toList()).get(0).getName();
            return name + " is most experienced surfer with "+mostEXP+" years experience.";
        }
    }

    private boolean contains(String name) {
        int index = -1;
        for (int i = 0; i < this.surfers.size(); i++) {
            if (this.surfers.get(i).getName().equals("name")) {
                index = i;
            }
        }
        return index >= 0;
    }
    public Surfer getSurfer(String name) {
        Surfer surfer = null;
        if (contains(name)) surfer = surfers.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList()).get(0);

        return surfer;
    }

    public int getCount() {
        return this.surfers.size();
    }

    public String getSurfersWithPersonalSurfboards() {
        List<Surfer> surfersWithBoards = surfers.stream().filter(Surfer::ownSurfBoard).collect(Collectors.toList());

        StringJoiner joiner = new StringJoiner(", ");
        surfersWithBoards.forEach(surfer -> joiner.add(surfer.getName()));

        if (joiner.length() == 0) return "There are no surfers.";
        else return "Surfers who have their own surfboards: " + joiner.toString();
    }

    public String getReport() {
        StringBuilder str = new StringBuilder();
        if (this.surfers.isEmpty()) {
            return "There are no surfers on "+getName()+" beach.";
        }
        else {
            str.append("Beach ").append(getName()).append(" was visited by the following surfers:\n");
            AtomicInteger count = new AtomicInteger(1);
            surfers.forEach(surfer -> {
                str.append(count).append(". ")
                        .append(surfer.getName())
                        .append(" with ")
                        .append(surfer.getExperience() > 0 ?
                                surfer.getExperience() + " years experience." :
                                "no experience.")
                        .append("\n");

                count.incrementAndGet();
            });
        }

        return str.toString();
    }
}
