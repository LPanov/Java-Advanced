package ExamPreparation.Regular17Feb2024.ChasingSharks;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new LinkedList<>();
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        }
        else System.out.println("This basin is at full capacity!");
    }
    public boolean removeShark(String kind) {
        Shark remShark = null;

        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)){
                sharks.remove(shark);
                return true;
            }
        }
        return false;
    }

    public Shark getLargestShark() {
        int largest = 0;
        Shark retShark = null;

        for (Shark shark : sharks) {
            if (shark.getLength() > largest) {
                largest = shark.getLength();
                retShark = shark;
            }
        }

        return retShark;
    }

    public Shark getShark(String kind) {
        Shark s = null;
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)){
                s = shark;
            }
        }
        return s;
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        AtomicInteger total = new AtomicInteger();
        sharks.forEach(s -> total.getAndAdd(s.getLength()));
        return total.get() / sharks.size();
    }

    public String report() {
        StringBuilder str = new StringBuilder();
        str.append("Sharks in ").append(this.name).append(":\n");
        sharks.forEach(s -> str.append(s.toString()).append("\n"));

        return str.toString();
    }


}
