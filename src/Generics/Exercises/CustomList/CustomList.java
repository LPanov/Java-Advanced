package Generics.Exercises.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class CustomList <T extends Comparable<T>>{
    List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    public int countGreater(T element) {
        AtomicInteger count = new AtomicInteger();
        this.list.forEach(l -> {
            if (l.compareTo(element) > 0) count.getAndIncrement();
        });
        return count.get();
    }
    public T getMin() {
        return Collections.min(this.list);
    }

    public  T getMax() {
        return Collections.max(this.list);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.list.size(); i++) {
            consumer.accept(this.list.get(i));
        }
    }

}
