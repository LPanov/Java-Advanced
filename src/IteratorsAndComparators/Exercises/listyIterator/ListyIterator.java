package IteratorsAndComparators.Exercises.listyIterator;

import java.util.Iterator;

public class ListyIterator implements Iterator<String> {
    private String[] strings;
    private int counter;

    public ListyIterator(String... strings) {
        this.strings = strings;
        this.counter = 0;
    }

    public String[] getStrings() {
        return strings;
    }

    @Override
    public boolean hasNext() {
        return counter < strings.length - 1;
    }

    @Override
    public String next() {
        return strings[++counter];
    }


}
