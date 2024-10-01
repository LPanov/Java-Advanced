package IteratorsAndComparators.Lab.comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int compareDiff = o1.getTitle().compareTo(o2.getTitle());
        if (compareDiff == 0) {
            return Integer.compare(o1.getYear(), o2.getYear());
        }
        else {
            return compareDiff;
        }
    }
}
