package IteratorsAndComparators.Exercises.LinkedListTraversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedListTraversal <T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return this.linkedList.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < this.linkedList.size(); i++) {
            action.accept(this.linkedList.get(i));
        }
     }

    LinkedList<T> linkedList;

    public LinkedListTraversal() {
        this.linkedList = new LinkedList<>();
    }

    public void add(T element) {
        this.linkedList.add(element);
    }

    public boolean remove(T element) {
        return this.linkedList.remove(element);
    }

    public int getSize() {
        return this.linkedList.size();
    }
}
