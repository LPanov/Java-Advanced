package Generics.Exercises.CountMethodString;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Box<T extends Comparable<T>>{
    List<T> list;

    public Box(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public int countGreater(T element) {
        AtomicInteger count = new AtomicInteger();
        this.list.forEach(l -> {
            if (l.compareTo(element) > 0) count.getAndIncrement();
        });
        return count.get();
    }

    public void swap(int index1, int index2) {
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.list.size(); i++) {
            output.append(this.list.get(i).getClass().getCanonicalName())
                    .append(": ")
                    .append(this.list.get(i))
                    .append("\n");
        }
        return output.toString();
    }
}
