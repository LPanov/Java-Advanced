package IteratorsAndComparators.Exercises.StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.lang.Integer;

public class Stack <T> implements Iterable<T> {
    private List<T> list;

    public Stack() {
        this.list = new ArrayList<>();
    }

    public void push(T element) {
        this.list.addLast(element);
    }

    public List<T> getList() {
        return list;
    }

    public T pop() {
       return this.list.removeLast();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }


    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = this.list.size() - 1; i >= 0; i--) {
            action.accept(this.list.get(i));
        }
    }
}
