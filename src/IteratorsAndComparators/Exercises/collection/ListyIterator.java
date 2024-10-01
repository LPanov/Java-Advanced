package IteratorsAndComparators.Exercises.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private String[] strings;
    private int counter;

    public ListyIterator(String... strings) {
        this.strings = strings;
        this.counter = 0;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(this.strings).iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        for (int i = 0; i < this.strings.length; i++) {
            action.accept(this.strings[i]);
        }
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }
    public String[] getStrings() {
        return strings;
    }

    public boolean hasNext() {
        return counter < strings.length - 1;
    }

    public String next() {
        return strings[++counter];
    }
}
